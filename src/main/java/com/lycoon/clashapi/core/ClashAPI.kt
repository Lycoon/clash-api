package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.CoreUtils.checkResponse
import com.lycoon.clashapi.core.CoreUtils.deserialize
import com.lycoon.clashapi.core.CoreUtils.formatTag
import com.lycoon.clashapi.core.Token.KeyHandler
import com.lycoon.clashapi.core.exception.ClashAPIException
import com.lycoon.clashapi.models.clan.*
import com.lycoon.clashapi.models.common.*
import com.lycoon.clashapi.models.league.League
import com.lycoon.clashapi.models.league.LeagueList
import com.lycoon.clashapi.models.league.LeagueSeason
import com.lycoon.clashapi.models.league.LeagueSeasonList
import com.lycoon.clashapi.models.player.*
import com.lycoon.clashapi.models.war.War
import com.lycoon.clashapi.models.war.Warlog
import com.lycoon.clashapi.models.war.WarlogEntry
import com.lycoon.clashapi.models.warleague.WarLeague
import com.lycoon.clashapi.models.warleague.WarLeagueGroup
import com.lycoon.clashapi.models.warleague.WarLeagueList
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kotlinx.serialization.decodeFromString
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.rmi.UnexpectedException


/**
 * Create an instance of this class to start using the API.<br></br>
 *
 * Are you lost? Check the [README](https://github.com/Lycoon/clash-api) to see what ClashAPI is all about.
 */
class ClashAPI() {
    private var token: String = ""
    private var http: OkHttpClient = OkHttpClient()

    private val log: Logger = LoggerFactory.getLogger(javaClass)
    constructor(username: String, password: String) : this() {
        if (token == "") {
            val keyHandler = KeyHandler()
            token = keyHandler.getValidKeys(username, password)[0]
            if (token != "") {
                log.info("API token generated successfully")
            } else {
                throw UnexpectedException("Unexpected error encountered while making keys for: $username")
            }
        }
        http = OkHttpClient()
    }

    constructor(token: String) : this(){
        this.token = token
        http = OkHttpClient()
    }


    private fun getBaseRequest(suffix: String): Request.Builder {
        return Request.Builder()
                .header("authorization", "Bearer $token")
                .url(CoreUtils.URL + CoreUtils.API_VERSION + suffix)
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

    private fun getTokenVerificationBody(token: String): RequestBody {
        val contentType: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()
        return "{\"token\":\"$token\"}".toRequestBody(contentType)
    }

    /**
     * Returns the warleague group in which the clan with the given tag is.
     *
     * @param clanTag `String` of the clan's tag
     * @return WarLeagueGroup
     * @see WarLeagueGroup
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getWarLeagueGroup(clanTag: String): WarLeagueGroup {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/currentwar/leaguegroup")
        return deserialize(res)
    }

    /**
     * Returns an individual warleague war associated to the given war tag.
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
    fun getWarLeagueWar(warTag: String): War {
        val tag = formatTag(warTag)
        val res = get("/clanwarleagues/wars/$tag")
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
        val res = get("/clans/$tag/warlog")
        return deserialize<Warlog>(res).items
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
        val res = get("/clans/$tag/currentwar")
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
        val res = get("/clans/$tag")
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
        val res = get("/clans/$tag/members")
        return deserialize<ClanMemberList>(res).items
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
        val res = get("/players/$tag")
        return deserialize(res)
    }

    /**
     * Returns whether the given player tag is verified or not.
     *
     * @param playerTag `String` of the player's tag
     * @param token `String` of the player token
     * @return a boolean
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun isVerifiedPlayer(playerTag: String, token: String): Boolean {
        val tag = formatTag(playerTag)
        val res = post("/players/$tag/verifytoken", getTokenVerificationBody(token))

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
        return deserialize<LeagueList>(res).items
    }

    /**
     * Returns league season rankings
     *
     * @param leagueId `String` of the league id
     * @param seasonId `String` of the season id
     * @return List<PlayerRanking>
     * @see PlayerRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLeagueSeasonRankings(leagueId: String, seasonId: String): List<PlayerRanking> {
        val res = get("/leagues/$leagueId/seasons/$seasonId")
        return deserialize<PlayerRankingList>(res).items
    }

    /**
     * Returns league information
     *
     * @param leagueId `String` of the league id
     * @return League
     * @see League
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLeague(leagueId: String): League {
        val res = get("/leagues/$leagueId")
        return deserialize(res)
    }

    /**
     * Returns league seasons
     *
     * @param leagueId `String` of the league id
     * @return List<LeagueSeason>
     * @see LeagueSeason
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLeagueSeasons(leagueId: String): List<LeagueSeason> {
        val res = get("/leagues/$leagueId/seasons")
        return deserialize<LeagueSeasonList>(res).items
    }

    /**
     * Returns warleague information
     *
     * @param leagueId `String` of the league id
     * @return WarLeague
     * @see WarLeague
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getWarLeague(leagueId: String): WarLeague {
        val res = get("/warleagues/$leagueId")
        return deserialize(res)
    }

    /**
     * Returns all warleagues
     *
     * @return List<WarLeague>
     * @see WarLeague
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getWarLeagues(): List<WarLeague> {
        val res = get("/warleagues")
        return deserialize<WarLeagueList>(res).items
    }

    /**
     * Returns clan rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @return List<ClanRanking>
     * @see ClanRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanRankings(locationId: String): List<ClanRanking> {
        val res = get("/locations/${locationId}/rankings/clans")
        return deserialize<ClanRankingList>(res).items
    }

    /**
     * Returns clan versus rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @return List<ClanVersusRanking>
     * @see ClanVersusRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanVersusRankings(locationId: String): List<ClanVersusRanking> {
        val res = get("/locations/${locationId}/rankings/clans-versus")
        return deserialize<ClanVersusRankingList>(res).items
    }

    /**
     * Returns player rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @return List<PlayerRanking>
     * @see PlayerRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerRankings(locationId: String): List<PlayerRanking> {
        val res = get("/locations/${locationId}/rankings/players")
        return deserialize<PlayerRankingList>(res).items
    }

    /**
     * Returns player versus rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @return List<PlayerVersusRanking>
     * @see PlayerVersusRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerVersusRankings(locationId: String): List<PlayerVersusRanking> {
        val res = get("/locations/${locationId}/rankings/players-versus")
        return deserialize<PlayerVersusRankingList>(res).items
    }

    /**
     * Returns locations
     *
     * @return List<Location>
     * @see Location
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLocations(): List<Location> {
        val res = get("/locations")
        return deserialize<LocationList>(res).items
    }

    /**
     * Returns specific location
     *
     * @param locationId `String` of the location id
     * @return Location
     * @see Location
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLocation(locationId: String): Location {
        val res = get("/locations/$locationId")
        return deserialize(res)
    }

    /**
     * Returns player labels
     *
     * @return List<Label>
     * @see Label
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerLabels(): List<Label> {
        val res = get("/labels/players")
        return deserialize<LabelList>(res).items
    }

    /**
     * Returns clan labels
     *
     * @return List<Label>
     * @see Label
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanLabels(): List<Label> {
        val res = get("/labels/clans")
        return deserialize<LabelList>(res).items
    }

}