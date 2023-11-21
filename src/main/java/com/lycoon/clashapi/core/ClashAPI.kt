package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.CoreUtils.deserialize
import com.lycoon.clashapi.core.CoreUtils.formatTag
import com.lycoon.clashapi.core.CoreUtils.checkResponse
import com.lycoon.clashapi.core.CoreUtils.unwrapList
import com.lycoon.clashapi.core.exception.ClashAPIException
import com.lycoon.clashapi.models.capital.CapitalRaidSeason
import com.lycoon.clashapi.models.capital.CapitalRanking
import com.lycoon.clashapi.models.clan.*
import com.lycoon.clashapi.models.common.*
import com.lycoon.clashapi.models.league.BuilderBaseLeague
import com.lycoon.clashapi.models.league.CapitalLeague
import com.lycoon.clashapi.models.league.League
import com.lycoon.clashapi.models.league.LeagueSeason
import com.lycoon.clashapi.models.player.*
import com.lycoon.clashapi.models.war.War
import com.lycoon.clashapi.models.war.Warlog
import com.lycoon.clashapi.models.war.WarlogEntry
import com.lycoon.clashapi.models.warleague.WarLeague
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
class ClashAPI(private val token: String)
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
    private fun get(url: String, queryParamsBuilder: QueryParamsBuilder? = null): Response
    {
        val req = getBaseRequest(url, queryParamsBuilder).build()
        val res = http.newCall(req).execute()
        return checkResponse(res)
    }

    @Throws(IOException::class, ClashAPIException::class)
    private fun post(url: String, body: RequestBody): Response
    {
        val res = http.newCall(getBaseRequest(url).post(body).build()).execute()
        return checkResponse(res)
    }

    private fun getTokenVerificationBody(token: String) : RequestBody
    {
        val contentType: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()
        return "{\"token\":\"$token\"}".toRequestBody(contentType)
    }

    // ##############################################
    // ||                Clans API                 ||
    // ##############################################

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
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<WarlogEntry>
     * @see WarlogEntry
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getWarlog(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<WarlogEntry> {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/warlog", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns found clans from a clan search.
     *
     * @param queryParamsBuilder (optional) `ClanQueryBuilder` to build the query parameters
     * @return List<Clan>
     * @see Clan
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClans(queryParamsBuilder: ClanQueryParamsBuilder? = null): List<Clan> {
        val res = get("/clans", queryParamsBuilder)
        return unwrapList(deserialize(res))
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
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<ClanMember>
     * @see ClanMember
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanMembers(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanMember> {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/members", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns the capital raid seasons of clan attached to the tag.
     *
     * @param clanTag `String` of the clan's tag
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<CapitalRaidSeason>
     * @see CapitalRaidSeason
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCapitalRaidSeasons(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<CapitalRaidSeason> {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/capitalraidseasons", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    // ##############################################
    // ||                Player API                ||
    // ##############################################

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

    // ##############################################
    // ||               Leagues API                ||
    // ##############################################

    /**
     * Returns all capital leagues from the game.
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<CapitalLeague>
     * @see CapitalLeague
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCapitalLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<CapitalLeague> {
        val res = get("/capitalleagues", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns all leagues from the game.
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<League>
     * @see League
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<League> {
        val res = get("/leagues", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns league season rankings
     *
     * @param leagueId `String` of the league id
     * @param seasonId `String` of the season id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<PlayerRanking>
     * @see PlayerRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLeagueSeasonRankings(
            leagueId: String,
            seasonId: String,
            queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<PlayerRanking>
    {
        val res = get("/leagues/$leagueId/seasons/$seasonId", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns capital league information
     *
     * @param leagueId `String` of the league id
     * @return CapitalLeague
     * @see CapitalLeague
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCapitalLeague(leagueId: String): CapitalLeague {
        val res = get("/capitalleagues/$leagueId")
        return deserialize(res)
    }

    /**
     * Returns builder base league information
     *
     * @param leagueId `String` of the league id
     * @return BuilderBaseLeague
     * @see BuilderBaseLeague
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getBuilderBaseLeague(leagueId: String): BuilderBaseLeague {
        val res = get("/builderbaseleagues/$leagueId")
        return deserialize(res)
    }

    /**
     * Returns all builder base leagues from the game.
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<BuilderBaseLeague>
     * @see BuilderBaseLeague
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getBuilderBaseLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<BuilderBaseLeague> {
        val res = get("/builderbaseleagues", queryParamsBuilder)
        return unwrapList(deserialize(res))
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
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<LeagueSeason>
     * @see LeagueSeason
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLeagueSeasons(leagueId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<LeagueSeason> {
        val res = get("/leagues/$leagueId/seasons", queryParamsBuilder)
        return unwrapList(deserialize(res))
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
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<WarLeague>
     * @see WarLeague
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getWarLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<WarLeague> {
        val res = get("/warleagues", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    // ##############################################
    // ||              Locations API               ||
    // ##############################################

    /**
     * Returns clan rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<ClanRanking>
     * @see ClanRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanRanking> {
        val res = get("/locations/${locationId}/rankings/clans", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns player rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<PlayerRanking>
     * @see PlayerRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<PlayerRanking> {
        val res = get("/locations/${locationId}/rankings/players", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns clan builder base rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<ClanBuilderBaseRanking>
     * @see ClanBuilderBaseRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanBuilderBaseRanking> {
        val res = get("/locations/${locationId}/rankings/clans-builder-base", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns clan versus rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<ClanBuilderBaseRanking>
     * @see ClanBuilderBaseRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Deprecated("Use getClanBuilderBaseRankings instead")
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanBuilderBaseRanking> {
        val res = get("/locations/${locationId}/rankings/clans-versus", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns player builder base rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<PlayerBuilderBaseRanking>
     * @see PlayerBuilderBaseRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<PlayerBuilderBaseRanking> {
        val res = get("/locations/${locationId}/rankings/players-builder-base", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns player versus rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<PlayerBuilderBaseRanking>
     * @see PlayerBuilderBaseRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Deprecated("Use getPlayerBuilderBaseRankings instead")
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<PlayerBuilderBaseRanking> {
        val res = get("/locations/${locationId}/rankings/players-versus", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns locations
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<Location>
     * @see Location
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getLocations(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<Location> {
        val res = get("/locations", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns capital rankings for a specific location
     *
     * @param locationId `String` of the location id
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<ClanCapitalRanking>
     * @see CapitalRanking
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getCapitalRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<CapitalRanking> {
        val res = get("/locations/$locationId/rankings/capitals", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns specific location information
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

    // ##############################################
    // ||               GoldPass API               ||
    // ##############################################

    /**
     * Returns gold pass information
     *
     * @return GoldPassSeason
     * @see GoldPassSeason
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getGoldPass(): GoldPassSeason {
        val res = get("/goldpass/seasons/current")
        return deserialize(res)
    }


    // ##############################################
    // ||                Labels API                ||
    // ##############################################

    /**
     * Returns player labels
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<Label>
     * @see Label
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerLabels(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<Label> {
        val res = get("/labels/players", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }

    /**
     * Returns clan labels
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<Label>
     * @see Label
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanLabels(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<Label> {
        val res = get("/labels/clans", queryParamsBuilder)
        return unwrapList(deserialize(res))
    }
}