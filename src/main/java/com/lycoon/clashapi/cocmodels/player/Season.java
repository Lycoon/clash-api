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

	public Integer getTrophies()
	{
		return trophies;
	}

	public String getId()
	{
		return id;
	}

	public Integer getRank()
	{
		return rank;
	}
}
