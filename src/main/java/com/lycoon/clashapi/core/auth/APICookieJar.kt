package com.lycoon.clashapi.core.auth

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * Provided to OkHttpClient to store and use auth cookies
 */
class APICookieJar: CookieJar
{
    private val cookieStore = HashMap<String, List<Cookie>>()

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>)
    {
        cookieStore[url.host] = cookies
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie>
    {
        val cookies = cookieStore[url.host]
        return cookies ?: ArrayList()
    }
}