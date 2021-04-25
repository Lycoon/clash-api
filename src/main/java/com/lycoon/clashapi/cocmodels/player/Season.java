package com.lycoon.clashapi.cocmodels.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Season
{
	@SerializedName("trophies")
	@Expose
	private Integer trophies;
	
	@SerializedName("id")
	@Expose
	private String id;
	
	@SerializedName("rank")
	@Expose
	private Integer rank;
	
	/**
	 * Returns the number of trophies the player had for this season.
	 * 
	 * @return an integer
	 */
	public Integer getTrophies()
	{
		return trophies;
	}
	
	/**
	 * Returns the id of the season.
	 * 
	 * @return a <code>String</code>
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * Returns the rank of the player for this season.
	 * 
	 * @return an integer
	 */
	public Integer getRank()
	{
		return rank;
	}
}
