package com.lycoon.clashapi.core

import com.google.gson.Gson
import com.lycoon.clashapi.core.exception.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.Response
import java.io.IOException

object CoreUtils {
    const val URL = "https://api.clashofclans.com/"
    const val API_VERSION = "v1"
    val gson = Gson()

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
        return Json.decodeFromString(res.body.toString())
    }

    fun formatTag(tag: String): String {
        return if (tag.startsWith("#")) tag.replace("#", "%23") else "%23$tag"
    }
}