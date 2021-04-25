package com.lycoon.clashapi.cocmodels.clanwar.league;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lycoon.clashapi.cocmodels.clanwar.ClanWarModel;

public class WarLeagueGroup
{
	@SerializedName("state")
	@Expose
	private String state;
	
	@SerializedName("season")
	@Expose
	private String season;
	
	@SerializedName("clans")
	@Expose
	private List<ClanWarModel> clans = null;
	
	@SerializedName("rounds")
	@Expose
	private List<Round> rounds = null;
	
	/**
	 * Returns the war state for this clan war league.
	 * 
	 * @return a String
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * Returns the current clan war league season, in the format MM-YYYY.
	 * 
	 * @return a String
	 */
	public String getSeason()
	{
		return season;
	}
	
	/**
	 * Returns the clans involved in this clan war league.
	 * 
	 * @return a <code>List</code> of <code>ClanWarModel</code> objects
	 * @see ClanWarModel
	 */
	public List<ClanWarModel> getClans()
	{
		return clans;
	}
	
	/**
	 * Returns the rounds of the clan war league.
	 * 
	 * @return a <code>List</code> of <code>Round</code> objects
	 * @see Round
	 */
	public List<Round> getRounds()
	{
		return rounds;
	}
}
