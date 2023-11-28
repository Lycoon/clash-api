package com.lycoon.clashapi.core.auth

import com.lycoon.clashapi.core.CoreUtils.DEVELOPER_API_URL
import com.lycoon.clashapi.core.CoreUtils.getRequestBody
import com.lycoon.clashapi.core.auth.dtos.Credentials
import com.lycoon.clashapi.core.exceptions.AuthException
import okhttp3.OkHttpClient
import okhttp3.Request

class AuthManager(client: OkHttpClient, email: String, password: String)
{
    /**
     * Logs in to the Clash of Clans API by filling OkHttpClient with auth cookie jar.
     */
    fun login(client: OkHttpClient, email: String, password: String)
    {
        val body = getRequestBody(Credentials(email, password))
        val req = Request.Builder().url("$DEVELOPER_API_URL/login").post(body).build()

        val res = client.newCall(req).execute()
        if (res.code == 403)
        {
            res.body.close()
            throw AuthException()
        }

        res.body.close()
    }

    init {
        login(client, email, password)
    }
}