package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.CoreUtils.API_URL
import com.lycoon.clashapi.core.CoreUtils.API_VERSION
import com.lycoon.clashapi.core.auth.APICookieJar
import com.lycoon.clashapi.core.auth.AuthManager
import com.lycoon.clashapi.core.auth.KeyManager
import com.lycoon.clashapi.core.auth.TokenList
import com.lycoon.clashapi.core.exceptions.ClashAPIException
import okhttp3.*
import org.slf4j.LoggerFactory
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger

abstract class ClashAPIClient
{
    constructor(token: String) { tokens = TokenList(token) }
    constructor(tokens: List<String>) { this.tokens = TokenList(tokens) }
    constructor(email: String, password: String)
    {
        val authManager = AuthManager(client, email, password)
        val keyManager = KeyManager()

        val validTokens = keyManager.getValidTokens(client)
        if (validTokens.isEmpty())
            this.tokens = TokenList(keyManager.createKey(client).token)
        else
            this.tokens = TokenList(validTokens)
    }

    private val client: OkHttpClient = OkHttpClient.Builder().cookieJar(APICookieJar()).build()
    private val log: org.slf4j.Logger = LoggerFactory.getLogger(ClashAPIClient::class.java)
    private val tokens: TokenList

    private fun getBaseAPIRequest(suffix: String, queryParamsBuilder: QueryParamsBuilder? = null): Request.Builder
    {
        val token = tokens.get()
        val query = queryParamsBuilder?.build() ?: ""

        return Request.Builder()
                .header("authorization", "Bearer $token")
                .url(API_URL + API_VERSION + suffix + query)
    }

    @Throws(IOException::class, ClashAPIException::class)
    protected fun get(url: String, queryParamsBuilder: QueryParamsBuilder? = null): Response
    {
        val req = getBaseAPIRequest(url, queryParamsBuilder).build()
        val res = client.newCall(req).execute()

        log.debug("Got response: {}", res)

        return CoreUtils.checkResponse(res)
    }

    @Throws(IOException::class, ClashAPIException::class)
    protected fun post(url: String, body: RequestBody): Response
    {
        val req = getBaseAPIRequest(url).post(body).build()
        val res = client.newCall(req).execute()

        log.debug("Got response: {}", res)

        return CoreUtils.checkResponse(res)
    }
}
