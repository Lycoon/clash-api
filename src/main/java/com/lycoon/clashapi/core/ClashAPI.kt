package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.CoreUtils.deserialize
import com.lycoon.clashapi.core.CoreUtils.formatTag
import com.lycoon.clashapi.core.CoreUtils.checkResponse
import com.lycoon.clashapi.core.exception.ClashAPIException
import com.lycoon.clashapi.models.clan.Clan
import com.lycoon.clashapi.models.clan.ClanMember
import com.lycoon.clashapi.models.common.TokenResponse
import com.lycoon.clashapi.models.league.League
import com.lycoon.clashapi.models.player.Player
import com.lycoon.clashapi.models.war.War
import com.lycoon.clashapi.models.war.WarlogEntry
import com.lycoon.clashapi.models.warleague.WarLeagueGroup
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

/**
 * Create an instance of this class to start using the API.<br></br>
 *
 * Are you lost? Check the [README](https://github.com/Lycoon/clash-api) to see what ClashAPI is all about.
 */
class ClashAPI(private val token: String) {
    private val http: OkHttpClient = OkHttpClient()
    private fun getBaseRequest(suffix: String): Request.Builder {
        return Request.Builder()
                .header("authorization", "Bearer $token")
                .url(CoreUtils.URL + CoreUtils.API_VERSION + "/" + suffix)
    }

    @Throws(IOException::class, ClashAPIException::class)
    private fun get(url: String): Response {
        val res = http.newCall(getBaseRequest(url).build()).execute()
        return checkResponse(res)
    }

    @Throws(IOException::class, ClashAPIException::class)
    private fun post(url: String, body: RequestBody): Response {
        val res = http.newCall(getBaseRequest(url).post(body).build()).execute()
        return checkResponse(res)
    }

    private fun getTokenVerificationBody(token: String) : RequestBody {
        val contentType: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()
        return "{\"token\":\"$token\"}".toRequestBody(contentType)
    }

    /**
     * Returns the CWL group in which the clan with the given tag is.
     *
     * @param clanTag `String` of the clan's tag
     * @return WarLeagueGroup
     * @see WarLeagueGroup
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCWLGroup(clanTag: String): WarLeagueGroup {
        val res = get("clans/${formatTag(clanTag)}/currentwar/leaguegroup")
        return deserialize(res)
    }

    /**
     * Returns the individual CWL war associated to the given war tag.
     * You can obtain individual CWL war tags from:
     * `ClashAPI.getCWLGroup(clanTag).getRounds(index).getWarTags(index)`
     *
     * @param warTag `String` of the war tag
     * @return War
     * @see War
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCWLWar(warTag: String): War {
        val res = get("clanwarleagues/wars/${formatTag(warTag)}")
        return deserialize(res)
    }

    /**
     * Returns the warlog of the clan with the given tag.
     *
     * @param clanTag `String` of the clan's tag
     * @return List<WarlogEntry>
     * @see WarlogEntry
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getWarlog(clanTag: String): List<WarlogEntry> {
        val tag = formatTag(clanTag)
        val res = get("clans/$tag/warlog")
        return deserialize(res)
    }

    /**
     * Returns the clan war occurring in the clan with the given tag.
     *
     * @param clanTag `String` of the clan's tag
     * @return War
     * @see War
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCurrentWar(clanTag: String): War {
        val tag = formatTag(clanTag)
        val res = get("clans/$tag/currentwar")
        return deserialize(res)
    }

    /**
     * Returns the clan attached to the tag.
     *
     * @param clanTag `String` of the clan's tag
     * @return Clan
     * @see Clan
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClan(clanTag: String): Clan {
        val tag = formatTag(clanTag)
        val res = get("clans/$tag")
        return deserialize(res)
    }

    /**
     * Returns the members of clan attached to the tag.
     *
     * @param clanTag `String` of the clan's tag
     * @return List<ClanMember>
     * @see ClanMember
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanMembers(clanTag: String): List<ClanMember> {
        val tag = formatTag(clanTag)
        val res = get("clans/$tag/members")
        return deserialize(res)
    }

    /**
     * Returns the player attached to the tag.
     *
     * @param playerTag `String` of the player's tag
     * @return Player
     * @see Player
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayer(playerTag: String): Player {
        val tag = formatTag(playerTag)
        val res = get("players/$tag")
        return deserialize(res)
    }

    /**
     * Returns whether the given player tag is verified or not.
     *
     * @param playerTag `String` of the player's tag
     * @return a boolean
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun isVerifiedPlayer(playerTag: String, token: String): Boolean {
        val tag = formatTag(playerTag)
        val res = post("players/$tag/verifytoken", getTokenVerificationBody(token))

        return deserialize<TokenResponse>(res).status == "ok"
    }

    /**
     * Returns all leagues from the game.
     *
     * @return List<League>
     * @see League
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLeagues(): List<League> {
        val res = get("/leagues")
        return deserialize(res)
    }
}