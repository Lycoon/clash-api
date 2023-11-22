package com.lycoon.clashapi.core.interfaces

import com.lycoon.clashapi.core.ClanQueryParamsBuilder
import com.lycoon.clashapi.core.SimpleQueryParamsBuilder
import com.lycoon.clashapi.core.exceptions.ClashAPIException
import com.lycoon.clashapi.models.capital.CapitalRaidSeason
import com.lycoon.clashapi.models.clan.Clan
import com.lycoon.clashapi.models.clan.ClanMember
import com.lycoon.clashapi.models.war.War
import com.lycoon.clashapi.models.war.WarlogEntry
import com.lycoon.clashapi.models.warleague.WarLeagueGroup
import java.io.IOException

interface IClanAPI
{
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
    fun getWarLeagueGroup(clanTag: String): WarLeagueGroup

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
    fun getWarLeagueWar(warTag: String): War

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
    fun getWarlog(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<WarlogEntry>

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
    fun getClans(queryParamsBuilder: ClanQueryParamsBuilder? = null): List<Clan>

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
    fun getCurrentWar(clanTag: String): War

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
    fun getClan(clanTag: String): Clan
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
    fun getClanMembers(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<ClanMember>

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
    fun getCapitalRaidSeasons(clanTag: String, queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<CapitalRaidSeason>
}