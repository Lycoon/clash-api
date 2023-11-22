package com.lycoon.clashapi.core.interfaces

import com.lycoon.clashapi.core.SimpleQueryParamsBuilder
import com.lycoon.clashapi.core.exceptions.ClashAPIException
import com.lycoon.clashapi.models.capital.CapitalRanking
import com.lycoon.clashapi.models.clan.ClanBuilderBaseRanking
import com.lycoon.clashapi.models.clan.ClanRanking
import com.lycoon.clashapi.models.common.Location
import com.lycoon.clashapi.models.player.PlayerBuilderBaseRanking
import com.lycoon.clashapi.models.player.PlayerRanking
import java.io.IOException

interface ILocationAPI
{
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
    fun getClanRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanRanking>

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
    fun getPlayerRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<PlayerRanking>

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
    fun getClanBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanBuilderBaseRanking>

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
    fun getClanVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanBuilderBaseRanking>

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
    fun getPlayerBuilderBaseRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<PlayerBuilderBaseRanking>

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
    fun getPlayerVersusRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<PlayerBuilderBaseRanking>

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
    fun getLocations(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<Location>

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
    fun getCapitalRankings(locationId: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<CapitalRanking>

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
    fun getLocation(locationId: String): Location
}