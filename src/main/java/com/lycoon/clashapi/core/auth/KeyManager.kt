package com.lycoon.clashapi.core.auth

import com.lycoon.clashapi.core.CoreUtils.DEVELOPER_API_URL
import com.lycoon.clashapi.core.CoreUtils.deserialize
import com.lycoon.clashapi.core.CoreUtils.getRequestBody
import com.lycoon.clashapi.core.auth.dtos.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.net.URL

class KeyManager
{
    val IP_CHECKER_URL = "http://checkip.amazonaws.com"
    val EMPTY_BODY = "".toRequestBody(null)

    private val ip: String = getIP()

    @Throws(IOException::class)
    private fun getIP(): String {
        return URL(IP_CHECKER_URL).readText().dropLast(1)
    }

    /**
     * Fetches the current keys from the developer
     * @param client The OkHttpClient needs to own auth cookies by calling login(email, password) before
     * @return List of keys
     */
    private fun fetchKeys(client: OkHttpClient): List<Key> {
        val req = Request.Builder().url("$DEVELOPER_API_URL/apikey/list").post(EMPTY_BODY).build()

        val res = client.newCall(req).execute()
        if (!res.isSuccessful) {
            res.body.close()
            throw Exception("Failed to fetch keys")
        }

        val obj = res.body.string()
        return deserialize<ListKeyResponse>(obj).keys
    }

    /**
     * Creates a new key for given IPs, also checks if there exists valid tokens to avoid duplicates
     * @param client The OkHttpClient needs to own auth cookies by calling login(email, password) before
     * @return generated token from the key
     */
    fun createKey(client: OkHttpClient): Key { return createKey(client, listOf(ip)) }
    fun createKey(client: OkHttpClient, ips: List<String>): Key {
        val keyCreation = KeyCreation(cidrRanges = ips)
        val body = getRequestBody(keyCreation)
        val req = Request.Builder().url("$DEVELOPER_API_URL/apikey/create").post(body).build()

        val res = client.newCall(req).execute()
        if (!res.isSuccessful) {
            res.body.close()
            throw Exception("Failed to generate new key")
        }

        val obj = res.body.string()
        return deserialize<KeyCreationResponse>(obj).key
    }

    /**
     * Deletes a key
     * @param client The OkHttpClient needs to own auth cookies by calling login(email, password) before
     * @param key The key to delete
     */
    fun deleteKey(client: OkHttpClient, key: String)
    {
        val body = getRequestBody(KeyDeletion(key))
        val req = Request.Builder().url("$DEVELOPER_API_URL/apikey/revoke").post(body).build()
        client.newCall(req).execute()
    }

    /**
     * Returns a list of valid tokens for given IPs
     */
    fun getValidTokens(client: OkHttpClient): List<String> { return getValidTokens(listOf(ip), fetchKeys(client)) }
    fun getValidTokens(ips: List<String>, keys: List<Key>): List<String> {
        return keys.filter{ it.ips.contains(ip) }.map{ it.token } // TODO: Check for given IPs and not only the current IP
    }
}