package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.exception.ClashAPIException
import com.lycoon.clashapi.old_models.clan.ClanModel
import com.lycoon.clashapi.old_models.clanwar.WarInfo
import com.lycoon.clashapi.old_models.clanwar.WarlogModel
import com.lycoon.clashapi.old_models.clanwar.league.WarLeagueGroup
import com.lycoon.clashapi.old_models.player.Player
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

/**
 * Create an instance of this class to start using the API.<br></br>
 *
 * Lost? Check the [README](https://github.com/Lycoon/clash-api) to see what ClashAPI is all about.
 */
class ClashAPI(private val token: String) {
    private val http: OkHttpClient = OkHttpClient()
    private fun getBaseRequest(suffix: String): Request.Builder {
        return Request.Builder()
                .header("authorization", "Bearer $token")
                .url(CoreUtils.URL + CoreUtils.API_VERSION + "/" + suffix)
    }

    @Throws(IOException::class, ClashAPIException::class)
    private fun getRequest(url: String): Response {
        val res = http.newCall(getBaseRequest(url).build()).execute()
        return CoreUtils.checkResponse(res)
    }

    @Throws(IOException::class, ClashAPIException::class)
    private fun postRequest(url: String, body: RequestBody): Response {
        val res = http.newCall(getBaseRequest(url).post(body).build()).execute()
        return CoreUtils.checkResponse(res)
    }

    /**
     * Returns whether the given player tag is verified or not.<br></br><br></br>
     * The tag is a unique identifier each player has, in the form of #AAAA00.<br></br>
     * It is displayed under the nickname on player's profile.
     *
     * @param playerTag - `String` of the player's tag
     * @return a boolean
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun isVerifiedPlayer(playerTag: String, token: String): Boolean {
        val contentType: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()
        val body = "{\"token\":\"$token\"}".toRequestBody(contentType)
        val res = postRequest("players/" + CoreUtils.formatTag(playerTag) + "/verifytoken", body)
        val tokenResponse = CoreUtils.deserialize<TokenResponse>(res)
        return tokenResponse.status == "ok"
    }

    /**
     * Returns the player attached to the tag.<br></br><br></br>
     * The tag is a unique identifier each player has, in the form of #AAAA00.<br></br>
     * It is displayed under the nickname on player's profile.
     *
     * @param playerTag - `String` of the player's tag
     * @return a `Player` object
     * @see Player
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayer(playerTag: String): Player {
        val res = getRequest("players/" + CoreUtils.formatTag(playerTag))
        return CoreUtils.deserialize(res)
    }

    /**
     * Returns the clan attached to the tag.<br></br><br></br>
     * The tag is a unique identifier each clan has, in the form of #AAAA00.<br></br>
     * It is displayed under the clan name on clan's profile.
     *
     * @param clanTag - `String` of the clan's tag
     * @return a `ClanModel` object
     * @see ClanModel
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClan(clanTag: String): ClanModel {
        val res = getRequest("clans/" + CoreUtils.formatTag(clanTag))
        return CoreUtils.deserialize(res)
    }

    /**
     * Returns the clan war occurring in the clan with the given tag.<br></br><br></br>
     * The tag is a unique identifier each clan has, in the form of #AAAA00.<br></br>
     * It is displayed under the clan name on clan's profile.
     *
     * @param clanTag - `String` of the clan's tag
     * @return a `WarInfo` object
     * @see WarInfo
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCurrentWar(clanTag: String): WarInfo {
        val res = getRequest("clans/" + CoreUtils.formatTag(clanTag) + "/currentwar")
        return CoreUtils.deserialize(res)
    }

    /**
     * Returns the warlog of the clan with the given tag.<br></br><br></br>
     * The tag is a unique identifier each clan has, in the form of #AAAA00.<br></br>
     * It is displayed under the clan name on clan's profile.
     *
     * @param clanTag - `String` of the clan's tag
     * @return a `WarlogModel` object
     * @see WarlogModel
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getWarlog(clanTag: String): WarlogModel {
        val res = getRequest("clans/" + CoreUtils.formatTag(clanTag) + "/warlog")
        return CoreUtils.deserialize(res)
    }

    /**
     * Returns the CWL group in which the clan with the given tag is.<br></br><br></br>
     * The tag is a unique identifier each clan has, in the form of #AAAA00.<br></br>
     * It is displayed under the clan name on clan's profile.
     *
     * @param clanTag - `String` of the clan's tag
     * @return a `WarLeagueGroup` object
     * @see WarLeagueGroup
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCWLGroup(clanTag: String): WarLeagueGroup {
        val res = getRequest("clans/" + CoreUtils.formatTag(clanTag) + "/currentwar/leaguegroup")
        return CoreUtils.deserialize(res)
    }

    /**
     * Returns the individual CWL war associated to the given war tag.<br></br><br></br>
     * You can obtain individual CWL war tags from:<br></br>
     * `ClashAPI.getCWLGroup(clanTag).getRounds(index).getWarTags(index)`
     *
     * @param warTag - `String` of the war tag
     * @return a `WarInfo` object
     * @see WarInfo
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCWLWar(warTag: String): WarInfo {
        val res = getRequest("clanwarleagues/wars/" + CoreUtils.formatTag(warTag))
        return CoreUtils.deserialize(res)
    }

}