package com.lycoon.clashapi.core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.lycoon.clashapi.cocmodels.clan.ClanModel;
import com.lycoon.clashapi.cocmodels.clanwar.ClanWarInfo;
import com.lycoon.clashapi.cocmodels.player.Player;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
	
	private Response makeAPICall(String url) throws IOException
	{
		Response res = http.newCall(buildReq(url)).execute();
		
		if (!res.isSuccessful())
			throw new IOException("[ClashAPI] Failed fetching data " + res);
		return res;
	}
	
	public Player getPlayer(String playerTag) throws IOException
	{
		Response res = makeAPICall("players/" +playerTag);
		return gson.fromJson(res.body().string(), Player.class);
	}
	
	public ClanModel getClan(String clanTag) throws IOException
	{
		Response res = makeAPICall("clans/" +clanTag);
		return gson.fromJson(res.body().string(), ClanModel.class);
	}
	
	public ClanWarInfo getCurrentWar(String clanTag) throws IOException
	{
		Response res = makeAPICall("clans/" +clanTag+ "/currentWar");
		return gson.fromJson(res.body().string(), ClanWarInfo.class);
	}
    
    // Returns data from a file
    static String getFileContent(String file) throws IOException
    {
    	return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }
}
