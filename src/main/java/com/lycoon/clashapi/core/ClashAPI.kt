package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.CoreUtils.deserialize
import com.lycoon.clashapi.core.CoreUtils.formatTag
import com.lycoon.clashapi.core.CoreUtils.getRequestBody
import com.lycoon.clashapi.core.CoreUtils.unwrapList
import com.lycoon.clashapi.core.auth.dtos.TokenValidation
import com.lycoon.clashapi.core.auth.dtos.TokenValidationResponse
import com.lycoon.clashapi.core.interfaces.*
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
import com.lycoon.clashapi.models.war.WarlogEntry
import com.lycoon.clashapi.models.warleague.WarLeague
import com.lycoon.clashapi.models.warleague.WarLeagueGroup

/**
 * Create an instance of this class to start using the API.<br></br>
 * Are you lost? Check the [README](https://github.com/Lycoon/clash-api) to see what ClashAPI is all about.
 */
class ClashAPI : ClashAPIClient, IClashAPI
{
    constructor(token: String) : super(token)
    constructor(tokens: List<String>) : super(tokens)
    constructor(email: String, password: String) : super(email, password)

    // ##############################################
    // ||                Clans API                 ||
    // ##############################################

    override fun getWarLeagueGroup(clanTag: String): WarLeagueGroup
    {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/currentwar/leaguegroup")
        return deserialize(res.body.string())
    }

    override fun getWarLeagueWar(warTag: String): War
    {
        val tag = formatTag(warTag)
        val res = get("/clanwarleagues/wars/$tag")
        return deserialize(res.body.string())
    }

    override fun getWarlog(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<WarlogEntry>
    {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/warlog", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getClans(queryParamsBuilder: ClanQueryParamsBuilder?): List<Clan>
    {
        val res = get("/clans", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCurrentWar(clanTag: String): War
    {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/currentwar")
        return deserialize(res.body.string())
    }

    override fun getClan(clanTag: String): Clan
    {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag")
        return deserialize(res.body.string())
    }

    override fun getClanMembers(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanMember>
    {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/members", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCapitalRaidSeasons(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<CapitalRaidSeason>
    {
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/capitalraidseasons", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    // ##############################################
    // ||                Player API                ||
    // ##############################################

    override fun getPlayer(playerTag: String): Player
    {
        val tag = formatTag(playerTag)
        val res = get("/players/$tag")
        return deserialize(res.body.string())
    }

    override fun isVerifiedPlayer(playerTag: String, token: String): Boolean
    {
        val tag = formatTag(playerTag)
        val res = post("/players/$tag/verifytoken", getRequestBody(TokenValidation(token)))
        return deserialize<TokenValidationResponse>(res.body.string()).status == "ok"
    }

    // ##############################################
    // ||                League API                ||
    // ##############################################

    override fun getCapitalLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<CapitalLeague>
    {
        val res = get("/capitalleagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<League>
    {
        val res = get("/leagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLeagueSeasonRankings(
            leagueId: String, seasonId: String,
            queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerRanking>
    {
        val res = get("/leagues/$leagueId/seasons/$seasonId", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCapitalLeague(leagueId: String): CapitalLeague
    {
        val res = get("/capitalleagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getBuilderBaseLeague(leagueId: String): BuilderBaseLeague
    {
        val res = get("/builderbaseleagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getBuilderBaseLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<BuilderBaseLeague>
    {
        val res = get("/builderbaseleagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLeague(leagueId: String): League
    {
        val res = get("/leagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getLeagueSeasons(leagueId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<LeagueSeason>
    {
        val res = get("/leagues/$leagueId/seasons", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getWarLeague(leagueId: String): WarLeague
    {
        val res = get("/warleagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getWarLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<WarLeague>
    {
        val res = get("/warleagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    // ##############################################
    // ||               Location API               ||
    // ##############################################

    override fun getClanRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanRanking>
    {
        val res = get("/locations/${locationId}/rankings/clans", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getPlayerRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerRanking>
    {
        val res = get("/locations/${locationId}/rankings/players", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getClanBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanBuilderBaseRanking>
    {
        val res = get("/locations/${locationId}/rankings/clans-builder-base", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    @Deprecated("Use getClanBuilderBaseRankings instead")
    override fun getClanVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanBuilderBaseRanking>
    {
        val res = get("/locations/${locationId}/rankings/clans-versus", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getPlayerBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerBuilderBaseRanking>
    {
        val res = get("/locations/${locationId}/rankings/players-builder-base", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    @Deprecated("Use getPlayerBuilderBaseRankings instead")
    override fun getPlayerVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerBuilderBaseRanking>
    {
        val res = get("/locations/${locationId}/rankings/players-versus", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLocations(queryParamsBuilder: SimpleQueryParamsBuilder?): List<Location>
    {
        val res = get("/locations", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCapitalRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<CapitalRanking>
    {
        val res = get("/locations/$locationId/rankings/capitals", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLocation(locationId: String): Location
    {
        val res = get("/locations/$locationId")
        return deserialize(res.body.string())
    }

    // ##############################################
    // ||               GoldPass API               ||
    // ##############################################

    override fun getGoldPass(): GoldPassSeason
    {
        val res = get("/goldpass/seasons/current")
        return deserialize(res.body.string())
    }

    // ##############################################
    // ||                 Label API                ||
    // ##############################################

    override fun getPlayerLabels(queryParamsBuilder: SimpleQueryParamsBuilder?): List<Label>
    {
        val res = get("/labels/players", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getClanLabels(queryParamsBuilder: SimpleQueryParamsBuilder?): List<Label>
    {
        val res = get("/labels/clans", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }
}