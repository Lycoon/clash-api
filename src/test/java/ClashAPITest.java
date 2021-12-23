import com.lycoon.clashapi.models.clan.Clan;
import com.lycoon.clashapi.models.clan.ClanMember;
import com.lycoon.clashapi.models.common.Label;
import com.lycoon.clashapi.models.common.Location;
import com.lycoon.clashapi.models.league.League;
import com.lycoon.clashapi.models.player.Player;
import com.lycoon.clashapi.core.ClashAPI;
import com.lycoon.clashapi.core.exception.NotFoundException;
import com.lycoon.clashapi.models.war.WarlogEntry;
import com.lycoon.clashapi.models.warleague.WarLeague;
import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ClashAPITest extends TestCase
{
    final ClashAPI clashAPI;
    final String CONFIG = "tokens.properties";

    final String PLAYER_TAG = "PGYROPR";
    final String CLAN_TAG = "UPCU2098";

    public ClashAPITest(String playerTestMethod)
    {
        super(playerTestMethod);

        // Loading secret tokens
        Properties tokens = new Properties();
        try {
            tokens.load(new FileInputStream(CONFIG));
        } catch (IOException ignored) {}

        clashAPI = new ClashAPI(tokens.getProperty("clash-of-clans"));
    }

    public void testWarlog() throws Exception
    {
        List<WarlogEntry> warlog = clashAPI.getWarlog(CLAN_TAG);

        assertNotNull(warlog);
    }

    public void testClanMembers() throws Exception
    {
        List<ClanMember> clanMembers = clashAPI.getClanMembers(CLAN_TAG);

        assertNotNull(clanMembers);
    }

    public void testLeague() throws Exception
    {
        League league = clashAPI.getLeague("29000000");

        assertNotNull(league);
    }

    public void testLeagues() throws Exception
    {
        List<League> leagues = clashAPI.getLeagues();

        assertNotNull(leagues);
    }

    public void testLocation() throws Exception
    {
        Location location = clashAPI.getLocation("32000000");

        assertNotNull(location);
    }

    public void testLocations() throws Exception
    {
        List<Location> locations = clashAPI.getLocations();

        assertNotNull(locations);
    }

    public void testWarLeague() throws Exception
    {
        WarLeague warLeague = clashAPI.getWarLeague("48000000");

        assertNotNull(warLeague);
    }

    public void testWarLeagues() throws Exception
    {
        List<WarLeague> warLeagues = clashAPI.getWarLeagues();

        assertNotNull(warLeagues);
    }

    public void testPlayerLabels() throws Exception
    {
        List<Label> playerLabels = clashAPI.getPlayerLabels();

        assertNotNull(playerLabels);
    }

    public void testClanLabels() throws Exception
    {
        List<Label> clanLabels = clashAPI.getClanLabels();

        assertNotNull(clanLabels);
    }

    public void testPlayerWithoutSharp() throws Exception
    {
        Player player = clashAPI.getPlayer(PLAYER_TAG);

        assertNotNull(player);
        assertEquals(player.getName(), "Bowwn");
        assertEquals(player.getTag(), "#" + PLAYER_TAG);
    }

    public void testClanWithoutSharp() throws Exception
    {
        Clan clan = clashAPI.getClan(CLAN_TAG);

        assertNotNull(clan);
        assertEquals(clan.getName(), "Amnésia");
        assertEquals(clan.getTag(), "#" + CLAN_TAG);
    }

    public void testPlayerWithSharp() throws Exception
    {
        Player player = clashAPI.getPlayer("#" + PLAYER_TAG);

        assertNotNull(player);
        assertEquals(player.getName(), "Bowwn");
        assertEquals(player.getTag(), "#" + PLAYER_TAG);
    }

    public void testClanWithSharp() throws Exception
    {
        Clan clan = clashAPI.getClan("#" + CLAN_TAG);

        assertNotNull(clan);
        assertEquals(clan.getName(), "Amnésia");
        assertEquals(clan.getTag(), "#" + CLAN_TAG);
    }

    public void testPlayer404() throws Exception
    {
        try {
            clashAPI.getPlayer("404");
        } catch (NotFoundException e) { return; }

        fail();
    }

    public void testClan404() throws Exception
    {
        try {
            clashAPI.getClan("404");
        } catch (NotFoundException e) { return; }

        fail();
    }
}
