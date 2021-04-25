package com.lycoon.clashapi.core;

import java.io.IOException;

import com.lycoon.clashapi.cocmodels.clan.ClanModel;
import com.lycoon.clashapi.cocmodels.clanwar.WarInfo;
import com.lycoon.clashapi.cocmodels.clanwar.WarlogModel;
import com.lycoon.clashapi.cocmodels.clanwar.league.WarLeagueGroup;
import com.lycoon.clashapi.cocmodels.player.Player;
import com.lycoon.clashapi.core.exception.ClashAPIException;

import okhttp3.*;

import static com.lycoon.clashapi.core.CoreUtils.*;

/**
 * Create an instance of this class to start using the API.<br>
 * 
 * Lost? Check the <a href="https://github.com/Lycoon/clash-api">README</a> to see what ClashAPI is all about.
 */
public class ClashAPI
{
	private final String token;
	private final OkHttpClient http;
	
	public ClashAPI(String token)
	{
		this.token = token;
		http = new OkHttpClient();
	}

	private Request.Builder getBaseRequest(String suffix) {
		return new Request.Builder()
				.header("authorization", "Bearer " + token)
				.url(URL + API_VERSION + "/" + suffix);
	}

	private Response getRequest(String url) throws IOException, ClashAPIException
	{
		Response res = http.newCall(getBaseRequest(url).build()).execute();
		return checkResponse(res);
	}

	private Response postRequest(String url, RequestBody body) throws IOException, ClashAPIException
	{
		Response res = http.newCall(getBaseRequest(url).post(body).build()).execute();
		return checkResponse(res);
	}

	/**
	 * Returns whether the given player tag is verified or not.<br><br>
	 * The tag is a unique identifier each player has, in the form of #AAAA00.<br>
	 * It is displayed under the nickname on player's profile.
	 *
	 * @param playerTag - <code>String</code> of the player's tag
	 * @return a boolean
	 * @throws IOException if the deserialization failed
	 * @throws ClashAPIException if the request to the game API failed
	 */
	public boolean isVerifiedPlayer(String playerTag, String token) throws IOException, ClashAPIException
	{
		MediaType contentType = MediaType.parse("application/json; charset=utf-8");
		RequestBody body = RequestBody.create(contentType, "{\"token\":\"" + token + "\"}");
		Response res = postRequest("players/" + formatTag(playerTag) + "/verifytoken", body);

		TokenResponse tokenResponse = deserialize(res, TokenResponse.class);
		return tokenResponse.getStatus().equals("ok");
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
		Response res = getRequest("players/" + formatTag(playerTag));
		return deserialize(res, Player.class);
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
		Response res = getRequest("clans/" + formatTag(clanTag));
		return deserialize(res, ClanModel.class);
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
		Response res = getRequest("clans/" + formatTag(clanTag)+ "/currentwar");
		return deserialize(res, WarInfo.class);
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
		Response res = getRequest("clans/" + formatTag(clanTag)+ "/warlog");
		return deserialize(res, WarlogModel.class);
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
		Response res = getRequest("clans/" + formatTag(clanTag)+ "/currentwar/leaguegroup");
		return deserialize(res, WarLeagueGroup.class);
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
		Response res = getRequest("clanwarleagues/wars/" + formatTag(warTag));
		return deserialize(res, WarInfo.class);
	}
}
