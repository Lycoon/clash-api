import junit.framework.TestCase
import com.lycoon.clashapi.core.ClashAPI
import com.lycoon.clashapi.core.CoreUtils
import java.io.FileInputStream
import java.io.IOException
import com.lycoon.clashapi.core.exception.NotFoundException
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import java.util.*

const val CLAN_TAG = "UPCU2098"
const val CONFIG = "tokens.properties"
const val PLAYER_TAG = "PGYROPR"

class ClashAPITest(playerTestMethod: String?) : TestCase(playerTestMethod) {
    private val clashAPI: ClashAPI

    init {
        // Loading secret tokens
        val tokens = Properties()
        try {
            tokens.load(FileInputStream(CONFIG))
        } catch (ignored: IOException) {
        }
        //clashAPI = ClashAPI(tokens.getProperty("clash-of-clans"))
        clashAPI = ClashAPI("");
    }

    @Serializable
    data class TestSerialize(
        val result: TestEnum,
        val teamSize: Int = 0,
    )
    {
        enum class TestEnum {LOSE, WIN, TIE}
    }

    fun testDebug() {
        val json = "{ \"result\": \"TIE\", \"teamSize\": 5 }"
        val deserialized = CoreUtils.json.decodeFromString<TestSerialize>(json);
        println(deserialized);
    }

    fun testWarlog() {
        val warlog = clashAPI.getWarlog(CLAN_TAG)
        assertNotNull(warlog)
    }

    fun testClanMembers() {
        val clanMembers = clashAPI.getClanMembers(CLAN_TAG)
        assertNotNull(clanMembers)
    }

    fun testLeague() {
        val league = clashAPI.getLeague("29000000")
        assertNotNull(league)
    }

    fun testLeagues() {
        val leagues = clashAPI.getLeagues()
        assertNotNull(leagues)
    }

    fun testLocation() {
        val location = clashAPI.getLocation("32000000")
        assertNotNull(location)
    }

    fun testLocations() {
        val locations = clashAPI.getLocations()
        assertNotNull(locations)
    }

    fun testWarLeague() {
        val warLeague = clashAPI.getWarLeague("48000000")
        assertNotNull(warLeague)
    }

    fun testWarLeagues() {
        val warLeagues = clashAPI.getWarLeagues()
        assertNotNull(warLeagues)
    }

    fun testPlayerLabels() {
        val playerLabels = clashAPI.getPlayerLabels()
        assertNotNull(playerLabels)
    }

    fun testClanLabels() {
        val clanLabels = clashAPI.getClanLabels()
        assertNotNull(clanLabels)
    }

    /*fun testWarLeagueGroup() {
        val warLeagueGroup = clashAPI.getWarLeagueGroup("#C0GJPLJG")
        assertNotNull(warLeagueGroup)
        print(warLeagueGroup.toString())
    }*/

    /*fun testWarLeagueWar() {
        val warLeagueWar = clashAPI.getWarLeagueWar("#0")
        assertNotNull(warLeagueWar)
        print(warLeagueWar.toString())
    }*/

    /*fun testClanWar() {
        val clanWar = clashAPI.getCurrentWar("#C0GJPLJG")
        assertNotNull(clanWar)
        print(clanWar.toString())
    }*/

    fun testPlayerWithoutSharp() {
        val player = clashAPI.getPlayer(PLAYER_TAG)
        assertNotNull(player)
        assertEquals(player.name, "Bowwn")
        assertEquals(player.tag, "#$PLAYER_TAG")
    }

    fun testClanWithoutSharp() {
        val clan = clashAPI.getClan(CLAN_TAG)
        assertNotNull(clan)
        assertEquals(clan.name, "Amnésia")
        assertEquals(clan.tag, "#$CLAN_TAG")
    }

    fun testPlayerWithSharp() {
        val player = clashAPI.getPlayer("#$PLAYER_TAG")
        assertNotNull(player)
        assertEquals(player.name, "Bowwn")
        assertEquals(player.tag, "#$PLAYER_TAG")
    }

    fun testClanWithSharp() {
        val clan = clashAPI.getClan("#$CLAN_TAG")
        assertNotNull(clan)
        assertEquals(clan.name, "Amnésia")
        assertEquals(clan.tag, "#$CLAN_TAG")
    }

    fun testPlayer404() {
        try {
            clashAPI.getPlayer("404")
        } catch (e: NotFoundException) {
            return
        }
        fail()
    }

    fun testClan404() {
        try {
            clashAPI.getClan("404")
        } catch (e: NotFoundException) {
            return
        }
        fail()
    }
}