package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.exceptions.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

object CoreUtils {
    const val JSON_CONTENT_TYPE = "application/json; charset=utf-8"
    const val API_URL = "https://api.clashofclans.com/"
    const val API_VERSION = "v1"

    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
        prettyPrint = true
    }

    @Throws(IOException::class)
    inline fun <reified T> deserialize(res: Response): T {
        return json.decodeFromString(res.body?.string() ?: "")
    }

    @Throws(IOException::class)
    inline fun <reified T> serialize(obj: T): String {
        return json.encodeToString<T>(obj)
    }

    /*
     * There are situations where we get a list from the API, but we can't return it directly as List<T>
     * because the API returns that list inside an object, within a single attribute named 'items' and
     * Kotlinx Serialization doesn't support that.
     *
     * For the concerned routes, we unwrap the list to avoid duplicating useless single-attribute classes
     * wrapping the list.
     */
    @Serializable
    class WrapperList<T>(val items: List<T>)
    fun <T> unwrapList(obj: WrapperList<T>): List<T> { return obj.items }

    /*
     * We don't want to invalidate a request if the provided tag doesn't start with a '#', so we prepend it
     * if it's not present. The %23 is the URL encoded version of '#'.
     */
    fun formatTag(tag: String): String{
        return if (tag.startsWith("#")) tag.replace("#", "%23") else "%23$tag"
    }

    /*
     * Prepares a RequestBody from a data class
     */
    inline fun <reified T> getRequestBody(obj: T): RequestBody {
        val body = serialize(obj)
        return body.toRequestBody(JSON_CONTENT_TYPE.toMediaTypeOrNull())
    }

    @Throws(ClashAPIException::class)
    fun checkResponse(res: Response): Response {
        if (res.isSuccessful) return res
        when (res.code) {
            400 -> throw BadRequestException()
            403 -> throw AuthException()
            404 -> throw NotFoundException()
            429 -> throw RateLimitException()
            503 -> throw MaintenanceException()
            else -> throw UnknownException()
        }
    }
}