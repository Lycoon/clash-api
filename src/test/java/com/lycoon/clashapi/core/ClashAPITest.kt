package com.lycoon.clashapi.core

import com.lycoon.clashapi.core.exceptions.NotFoundException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileInputStream
import java.io.IOException
import java.util.*

const val CLAN_TAG = "UPCU2098"
const val CONFIG = "tokens.properties"
const val PLAYER_TAG = "PGYR0PR"

internal class ClashAPITest() {
    private val clashAPI: ClashAPI

    init {
        // Loading secret tokens
        val tokens = Properties()
        try {
            tokens.load(FileInputStream(CONFIG))
        } catch (ignored: IOException) {
        }
        //clashAPI = ClashAPI(tokens.getProperty("clash-of-clans"))
        clashAPI = ClashAPI(tokens.getProperty("email"), tokens.getProperty("password"))
    }

    @Test
    internal fun testWarlog() {
        val warlog = clashAPI.getWarlog(CLAN_TAG)
        assertNotNull(warlog)
    }

    @Test
    internal fun testClanMembers() {
        val clanMembers = clashAPI.getClanMembers(CLAN_TAG)
        assertNotNull(clanMembers)
    }

    @Test
    internal fun testLeague() {
        val league = clashAPI.getLeague("29000000")
        assertNotNull(league)
    }

    @Test
    internal fun testLeagues() {
        val leagues = clashAPI.getLeagues()
        assertNotNull(leagues)
    }

    @Test
    internal fun testLocation() {
        val location = clashAPI.getLocation("32000000")
        assertNotNull(location)
    }

    @Test
    internal fun testLocations() {
        val locations = clashAPI.getLocations()
        assertNotNull(locations)
    }

    @Test
    internal fun testWarLeague() {
        val warLeague = clashAPI.getWarLeague("48000000")
        assertNotNull(warLeague)
    }

    @Test
    internal fun testWarLeagues() {
        val warLeagues = clashAPI.getWarLeagues()
        assertNotNull(warLeagues)
    }

    @Test
    internal fun testPlayerLabels() {
        val playerLabels = clashAPI.getPlayerLabels()
        assertNotNull(playerLabels)
    }

    @Test
    internal fun testClanLabels() {
        val clanLabels = clashAPI.getClanLabels()
        assertNotNull(clanLabels)
    }

    @Test
    internal fun testWarLeagueGroup() {
        try {
            val warLeagueGroup = clashAPI.getWarLeagueGroup(CLAN_TAG)
            assertNotNull(warLeagueGroup)
        } catch (ex: NotFoundException) {
            // Do nothing
            // This test will fail if the clan is not in a war league
        }
    }

    @Test
    internal fun testWarLeagueWar() {
        val warLeagueWar = clashAPI.getWarLeagueWar("#0")
        assertNotNull(warLeagueWar)
    }

    @Test
    internal fun testClanWar() {
        val clanWar = clashAPI.getCurrentWar("#C0GJPLJG")
        assertNotNull(clanWar)
    }

    @Test
    internal fun testPlayerWithoutSharp() {
        val player = clashAPI.getPlayer(PLAYER_TAG)
        assertNotNull(player)
        assertEquals("Bowwn", player.name)
        assertEquals("#$PLAYER_TAG", player.tag)
    }

    @Test
    internal fun testClanWithoutSharp() {
        val clan = clashAPI.getClan(CLAN_TAG)
        assertNotNull(clan)
        assertEquals("Amnésia", clan.name)
        assertEquals("#$CLAN_TAG", clan.tag)
    }

    @Test
    internal fun testPlayerWithSharp() {
        val player = clashAPI.getPlayer("#$PLAYER_TAG")
        assertNotNull(player)
        assertEquals("Bowwn", player.name)
        assertEquals("#$PLAYER_TAG", player.tag)
    }

    @Test
    internal fun testNewPlayer() {
        val player = clashAPI.getPlayer("#GL2GLGLYR")
        assertNotNull(player)
    }

    @Test
    internal fun testClanWithSharp() {
        val clan = clashAPI.getClan("#$CLAN_TAG")
        assertNotNull(clan)
        assertEquals("Amnésia", clan.name)
        assertEquals("#$CLAN_TAG", clan.tag)
    }

    @Test
    internal fun testClanSearch() {
        val query = ClanQueryParamsBuilder(name = "toto");
        val clans = clashAPI.getClans(query);
        assertNotNull(clans)
    }

    @Test
    internal fun testPlayer404() {
        assertThrows<NotFoundException> { clashAPI.getPlayer("404") }
    }

    @Test
    internal fun testClan404() {
        assertThrows<NotFoundException> { clashAPI.getClan("404") }
    }
}
