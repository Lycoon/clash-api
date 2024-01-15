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
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Create an instance of this class to start using the API.<br></br>
 * Are you lost? Check the [README](https://github.com/Lycoon/clash-api) to see what ClashAPI is all about.
 */
class ClashAPI : ClashAPIClient, IClashAPI
{
    constructor(token: String) : super(token)
    constructor(tokens: List<String>) : super(tokens)
    constructor(email: String, password: String) : super(email, password)

    private val log: Logger = LoggerFactory.getLogger(ClashAPI::class.java)

    // ##############################################
    // ||                Clans API                 ||
    // ##############################################

    override fun getWarLeagueGroup(clanTag: String): WarLeagueGroup
    {
        log.trace("Getting war league group for clan {}", clanTag)
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/currentwar/leaguegroup")
        return deserialize(res.body.string())
    }

    override fun getWarLeagueWar(warTag: String): War
    {
        log.trace("Getting war league war {}", warTag)
        val tag = formatTag(warTag)
        val res = get("/clanwarleagues/wars/$tag")
        return deserialize(res.body.string())
    }

    override fun getWarlog(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<WarlogEntry>
    {
        log.trace("Getting war log for clan {} with filter {}", clanTag, queryParamsBuilder)
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/warlog", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getClans(queryParamsBuilder: ClanQueryParamsBuilder?): List<Clan>
    {
        log.trace("Getting clans with filter {}", queryParamsBuilder)
        val res = get("/clans", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCurrentWar(clanTag: String): War
    {
        log.trace("Getting current war for clan {}", clanTag)
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/currentwar")
        return deserialize(res.body.string())
    }

    override fun getClan(clanTag: String): Clan
    {
        log.trace("Getting clan {}", clanTag)
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag")
        return deserialize(res.body.string())
    }

    override fun getClanMembers(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanMember>
    {
        log.trace("Getting clan members for clan {} with filter {}", clanTag, queryParamsBuilder)
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/members", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCapitalRaidSeasons(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<CapitalRaidSeason>
    {
        log.trace("Getting capital raid seasons for clan {} with filter {}", clanTag, queryParamsBuilder)
        val tag = formatTag(clanTag)
        val res = get("/clans/$tag/capitalraidseasons", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    // ##############################################
    // ||                Player API                ||
    // ##############################################

    override fun getPlayer(playerTag: String): Player
    {
        log.trace("Getting player {}", playerTag)
        val tag = formatTag(playerTag)
        val res = get("/players/$tag")
        return deserialize(res.body.string())
    }

    override fun isVerifiedPlayer(playerTag: String, token: String): Boolean
    {
        log.trace("Verifying player {} with token {}", playerTag, token)
        val tag = formatTag(playerTag)
        val res = post("/players/$tag/verifytoken", getRequestBody(TokenValidation(token)))
        return deserialize<TokenValidationResponse>(res.body.string()).status == "ok"
    }

    // ##############################################
    // ||                League API                ||
    // ##############################################

    override fun getCapitalLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<CapitalLeague>
    {
        log.trace("Getting capital leagues with filter {}", queryParamsBuilder)
        val res = get("/capitalleagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<League>
    {
        log.trace("Getting leagues with filter {}", queryParamsBuilder)
        val res = get("/leagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLeagueSeasonRankings(
            leagueId: String,
            seasonId: String,
            queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerRanking>
    {
        log.trace("Getting league season rankings for league {} and season {} with filter {}", leagueId, seasonId, queryParamsBuilder)
        val res = get("/leagues/$leagueId/seasons/$seasonId", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCapitalLeague(leagueId: String): CapitalLeague
    {
        log.trace("Getting capital league {}", leagueId)
        val res = get("/capitalleagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getBuilderBaseLeague(leagueId: String): BuilderBaseLeague
    {
        log.trace("Getting builder base league {}", leagueId)
        val res = get("/builderbaseleagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getBuilderBaseLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<BuilderBaseLeague>
    {
        log.trace("Getting builder base leagues with filter {}", queryParamsBuilder)
        val res = get("/builderbaseleagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLeague(leagueId: String): League
    {
        log.trace("Getting league {}", leagueId)
        val res = get("/leagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getLeagueSeasons(leagueId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<LeagueSeason>
    {
        log.trace("Getting league seasons for league {} with filter {}", leagueId, queryParamsBuilder)
        val res = get("/leagues/$leagueId/seasons", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getWarLeague(leagueId: String): WarLeague
    {
        log.trace("Getting war league {}", leagueId)
        val res = get("/warleagues/$leagueId")
        return deserialize(res.body.string())
    }

    override fun getWarLeagues(queryParamsBuilder: SimpleQueryParamsBuilder?): List<WarLeague>
    {
        log.trace("Getting war leagues with filter {}", queryParamsBuilder)
        val res = get("/warleagues", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    // ##############################################
    // ||               Location API               ||
    // ##############################################

    override fun getClanRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanRanking>
    {
        log.trace("Getting clan rankings for location {} with filter {}", locationId, queryParamsBuilder)
        val res = get("/locations/${locationId}/rankings/clans", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getPlayerRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerRanking>
    {
        log.trace("Getting player rankings for location {} with filter {}", locationId, queryParamsBuilder)
        val res = get("/locations/${locationId}/rankings/players", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getClanBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanBuilderBaseRanking>
    {
        log.trace("Getting clan builder base rankings for location {} with filter {}", locationId, queryParamsBuilder)
        val res = get("/locations/${locationId}/rankings/clans-builder-base", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    @Deprecated("Use getClanBuilderBaseRankings instead")
    override fun getClanVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<ClanBuilderBaseRanking>
    {
        log.trace("Getting clan versus rankings for location {} with filter {}", locationId, queryParamsBuilder)
        val res = get("/locations/${locationId}/rankings/clans-versus", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getPlayerBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerBuilderBaseRanking>
    {
        log.trace("Getting player builder base rankings for location {} with filter {}", locationId, queryParamsBuilder)
        val res = get("/locations/${locationId}/rankings/players-builder-base", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    @Deprecated("Use getPlayerBuilderBaseRankings instead")
    override fun getPlayerVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<PlayerBuilderBaseRanking>
    {
        log.trace("Getting player versus rankings for location {} with filter {}", locationId, queryParamsBuilder)
        val res = get("/locations/${locationId}/rankings/players-versus", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLocations(queryParamsBuilder: SimpleQueryParamsBuilder?): List<Location>
    {
        log.trace("Getting locations with filter {}", queryParamsBuilder)
        val res = get("/locations", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getCapitalRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder?): List<CapitalRanking>
    {
        log.trace("Getting capital rankings for location {} with filter {}", locationId, queryParamsBuilder)
        val res = get("/locations/$locationId/rankings/capitals", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getLocation(locationId: String): Location
    {
        log.trace("Getting location {}", locationId)
        val res = get("/locations/$locationId")
        return deserialize(res.body.string())
    }

    // ##############################################
    // ||               GoldPass API               ||
    // ##############################################

    override fun getGoldPass(): GoldPassSeason
    {
        log.trace("Getting gold pass")
        val res = get("/goldpass/seasons/current")
        return deserialize(res.body.string())
    }

    // ##############################################
    // ||                 Label API                ||
    // ##############################################

    override fun getPlayerLabels(queryParamsBuilder: SimpleQueryParamsBuilder?): List<Label>
    {
        log.trace("Getting player labels with filter {}", queryParamsBuilder)
        val res = get("/labels/players", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }

    override fun getClanLabels(queryParamsBuilder: SimpleQueryParamsBuilder?): List<Label>
    {
        log.trace("Getting clan labels with filter {}", queryParamsBuilder)
        val res = get("/labels/clans", queryParamsBuilder)
        return unwrapList(deserialize(res.body.string()))
    }
}
