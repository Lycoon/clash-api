import com.lycoon.clashapi.old_models.clan.ClanModel;
import com.lycoon.clashapi.old_models.player.Player;
import com.lycoon.clashapi.core.ClashAPI;
import com.lycoon.clashapi.core.exception.NotFoundException;
import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.IOException;
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
        try
        {
            tokens.load(new FileInputStream(CONFIG));
        }
        catch (IOException ignored) {}

        clashAPI = new ClashAPI(tokens.getProperty("clash-of-clans"));
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
        ClanModel clan = clashAPI.getClan(CLAN_TAG);

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
        ClanModel clan = clashAPI.getClan("#" + CLAN_TAG);

        assertNotNull(clan);
        assertEquals(clan.getName(), "Amnésia");
        assertEquals(clan.getTag(), "#" + CLAN_TAG);
    }

    public void testPlayer404() throws Exception
    {
        try
        {
            clashAPI.getPlayer("404");
        }
        catch (NotFoundException e) { return; }

        fail();
    }

    public void testClan404() throws Exception
    {
        try
        {
            clashAPI.getClan("404");
        }
        catch (NotFoundException e) { return; }

        fail();
    }
}
