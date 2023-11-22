package com.lycoon.clashapi.core.interfaces

import com.lycoon.clashapi.core.SimpleQueryParamsBuilder
import com.lycoon.clashapi.core.exceptions.ClashAPIException
import com.lycoon.clashapi.models.league.BuilderBaseLeague
import com.lycoon.clashapi.models.league.CapitalLeague
import com.lycoon.clashapi.models.league.League
import com.lycoon.clashapi.models.league.LeagueSeason
import com.lycoon.clashapi.models.player.PlayerRanking
import com.lycoon.clashapi.models.warleague.WarLeague
import java.io.IOException

interface ILeagueAPI
{
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
    fun getCapitalLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<CapitalLeague>

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
    fun getLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<League>

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
            queryParamsBuilder: SimpleQueryParamsBuilder? = null
    ): List<PlayerRanking>

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
    fun getCapitalLeague(leagueId: String): CapitalLeague

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
    fun getBuilderBaseLeague(leagueId: String): BuilderBaseLeague

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
    fun getBuilderBaseLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<BuilderBaseLeague>

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
    fun getLeague(leagueId: String): League

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
    fun getLeagueSeasons(leagueId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<LeagueSeason>

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
    fun getWarLeague(leagueId: String): WarLeague

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
    fun getWarLeagues(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<WarLeague>
}