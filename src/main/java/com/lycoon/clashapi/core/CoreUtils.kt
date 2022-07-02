package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.exception.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import okhttp3.Response
import java.io.IOException

object CoreUtils {
    const val URL = "https://api.clashofclans.com/"
    const val API_VERSION = "v1"
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
        prettyPrint = true
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

    @Throws(IOException::class)
    inline fun <reified T> deserialize(res: Response): T {
        return json.decodeFromString(res.body?.string() ?: "")
    }

    fun formatTag(tag: String): String {
        var tag = tag.toUpperCase()
        if (!tag.startsWith("#")) {
            tag = "#$tag"
        }
        if (checkTagWithRegex(tag)) {
            return if (tag.startsWith("#")) tag.replace("#", "%23") else "%23$tag"
        } else {
            throw NotFoundException() // Throws a 404 exception as it's guaranteed to not be a tag
        }
    }

    fun checkTagWithRegex(tag: String ): Boolean {
        return tag.toUpperCase().matches("^#[PYLQGRJCUV0289]+$".toRegex())
    }
}