package com.lycoon.clashapi.core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.lycoon.clashapi.cocmodels.clan.ClanModel;
import com.lycoon.clashapi.cocmodels.clanwar.WarInfo;
import com.lycoon.clashapi.cocmodels.clanwar.WarlogModel;
import com.lycoon.clashapi.cocmodels.clanwar.league.WarLeagueGroup;
import com.lycoon.clashapi.cocmodels.player.Player;
import com.lycoon.clashapi.core.exception.AuthException;
import com.lycoon.clashapi.core.exception.BadRequestException;
import com.lycoon.clashapi.core.exception.ClashAPIException;
import com.lycoon.clashapi.core.exception.MaintenanceException;
import com.lycoon.clashapi.core.exception.NotFoundException;
import com.lycoon.clashapi.core.exception.RateLimitException;
import com.lycoon.clashapi.core.exception.UnknownException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create an instance of this class to start using the API.<br>
 * 
 * Lost? Check the <a href="https://github.com/Lycoon/clash-api">README</a> to see what ClashAPI is all about.
 */
public class ClashAPI
{
	private final static String URL = "https://api.clashofclans.com/";
	private final static String API_VERSION = "v1";
	
	private String token;
	private OkHttpClient http;
	private Gson gson;
	
	public ClashAPI(String token)
	{
		this.token = token;
		http = new OkHttpClient();
		gson = new Gson();
	}
	
	private Request buildReq(String suffix) throws IOException
	{
		return new Request.Builder()
			.header("authorization", "Bearer " + token)
			.url(URL + API_VERSION + "/" + suffix)
			.build();
	}
	
	private Response makeAPICall(String url) throws IOException, ClashAPIException
	{
		Response res = http.newCall(buildReq(url)).execute();
		if (!res.isSuccessful())
		{
			switch(res.code())
			{
				case 400:
					throw new BadRequestException("400");
				case 403:
					throw new AuthException("403");
				case 404:
					throw new NotFoundException("404");
				case 429:
					throw new RateLimitException("429");
				case 503:
					throw new MaintenanceException("503");
				default:
					throw new UnknownException("500");
			}
		}
		return res;
	}
	
	private String formatTag(String tag)
	{
		return tag.replace("#", "%23");
	}
	
	/**
	 * Returns the player attached to the tag.<br><br>
	 * The tag is a unique identifier each player has, in the form of #AAAA00.<br>
	 * It is displayed under the nickname on player's profile.
	 * 
	 * @param playerTag - <code>String</code> of the player's tag
	 * @return a <code>Player</code> object
	 * @see Player
	 * @throws IOException if the deserialization failed
	 * @throws ClashAPIException if the request to the game API failed
	 */
	public Player getPlayer(String playerTag) throws IOException, ClashAPIException
	{
		Response res = makeAPICall("players/" +formatTag(playerTag));
		return gson.fromJson(res.body().string(), Player.class);
	}
	
	/**
	 * Returns the clan attached to the tag.<br><br>
	 * The tag is a unique identifier each clan has, in the form of #AAAA00.<br>
	 * It is displayed under the clan name on clan's profile.
	 * 
	 * @param clanTag - <code>String</code> of the clan's tag
	 * @return a <code>ClanModel</code> object
	 * @see ClanModel
	 * @throws IOException if the deserialization failed
	 * @throws ClashAPIException if the request to the game API failed
	 */
	public ClanModel getClan(String clanTag) throws IOException, ClashAPIException
	{
		Response res = makeAPICall("clans/" +formatTag(clanTag));
		return gson.fromJson(res.body().string(), ClanModel.class);
	}
	
	/**
	 * Returns the clan war occurring in the clan with the given tag.<br><br>
	 * The tag is a unique identifier each clan has, in the form of #AAAA00.<br>
	 * It is displayed under the clan name on clan's profile.
	 * 
	 * @param clanTag - <code>String</code> of the clan's tag
	 * @return a <code>WarInfo</code> object
	 * @see WarInfo
	 * @throws IOException if the deserialization failed
	 * @throws ClashAPIException if the request to the game API failed
	 */
	public WarInfo getCurrentWar(String clanTag) throws IOException, ClashAPIException
	{
		Response res = makeAPICall("clans/" +formatTag(clanTag)+ "/currentwar");
		return gson.fromJson(res.body().string(), WarInfo.class);
	}
	
	/**
	 * Returns the warlog of the clan with the given tag.<br><br>
	 * The tag is a unique identifier each clan has, in the form of #AAAA00.<br>
	 * It is displayed under the clan name on clan's profile.
	 * 
	 * @param clanTag - <code>String</code> of the clan's tag
	 * @return a <code>WarlogModel</code> object
	 * @see WarlogModel
	 * @throws IOException if the deserialization failed
	 * @throws ClashAPIException if the request to the game API failed
	 */
	public WarlogModel getWarlog(String clanTag) throws IOException, ClashAPIException
	{
		Response res = makeAPICall("clans/" +formatTag(clanTag)+ "/warlog");
		return gson.fromJson(res.body().string(), WarlogModel.class);
	}
	
	/**
	 * Returns the CWL group in which the clan with the given tag is.<br><br>
	 * The tag is a unique identifier each clan has, in the form of #AAAA00.<br>
	 * It is displayed under the clan name on clan's profile.
	 * 
	 * @param clanTag - <code>String</code> of the clan's tag
	 * @return a <code>WarLeagueGroup</code> object
	 * @see WarLeagueGroup
	 * @throws IOException if the deserialization failed
	 * @throws ClashAPIException if the request to the game API failed
	 */
	public WarLeagueGroup getCWLGroup(String clanTag) throws IOException, ClashAPIException
	{
		Response res = makeAPICall("clans/" +formatTag(clanTag)+ "/currentwar/leaguegroup");
		return gson.fromJson(res.body().string(), WarLeagueGroup.class);
	}
	
	/**
	 * Returns the individual CWL war associated to the given war tag.<br><br>
	 * You can obtain individual CWL war tags from:<br>
	 * <code>ClashAPI.getCWLGroup(clanTag).getRounds(index).getWarTags(index)</code>
	 * 
	 * @param warTag - <code>String</code> of the war tag
	 * @return a <code>WarInfo</code> object
	 * @see WarInfo
	 * @throws IOException if the deserialization failed
	 * @throws ClashAPIException if the request to the game API failed
	 */
	public WarInfo getCWLWar(String warTag) throws IOException, ClashAPIException
	{
		Response res = makeAPICall("clanwarleagues/wars/" +formatTag(warTag));
		return gson.fromJson(res.body().string(), WarInfo.class);
	}
    
    // Returns data from a file
    static String getFileContent(String file) throws IOException
    {
    	return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }
}
