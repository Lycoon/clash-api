package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.exceptions.ClashAPIException
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.CompletableFuture

abstract class ClashAPIClient(private val token: String)
{
    private val http: OkHttpClient = OkHttpClient()
    private fun getBaseRequest(suffix: String, queryParamsBuilder: QueryParamsBuilder? = null): Request.Builder
    {
        val query = queryParamsBuilder?.build() ?: ""
        return Request.Builder()
                .header("authorization", "Bearer $token")
                .url(CoreUtils.URL + CoreUtils.API_VERSION + suffix + query)
    }

    @Throws(IOException::class, ClashAPIException::class)
    protected fun get(url: String, queryParamsBuilder: QueryParamsBuilder? = null): Response
    {
        val req = getBaseRequest(url, queryParamsBuilder).build()
        val res = http.newCall(req).execute()
        return CoreUtils.checkResponse(res)
    }

    @Throws(IOException::class, ClashAPIException::class)
    protected fun post(url: String, body: RequestBody): Response
    {
        val res = http.newCall(getBaseRequest(url).post(body).build()).execute()
        return CoreUtils.checkResponse(res)
    }

    protected fun getTokenVerificationBody(token: String) : RequestBody
    {
        val contentType: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()
        return "{\"token\":\"$token\"}".toRequestBody(contentType)
    }
}