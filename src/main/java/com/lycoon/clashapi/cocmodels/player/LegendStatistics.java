package com.lycoon.clashapi.cocmodels.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LegendStatistics
{
	@SerializedName("currentSeason")
	@Expose
	private Season currentSeason;
	
	@SerializedName("previousSeason")
	@Expose
	private Season previousSeason;
	
	@SerializedName("bestSeason")
	@Expose
	private Season bestSeason;
	
	@SerializedName("previousVersusSeason")
	@Expose
	private Season previousVersusSeason;
	
	@SerializedName("bestVersusSeason")
	@Expose
	private Season bestVersusSeason;
	
	@SerializedName("legendTrophies")
	@Expose
	private Integer legendTrophies;

	public Season getCurrentSeason()
	{
		return currentSeason;
	}

	public Season getPreviousSeason()
	{
		return previousSeason;
	}

	public Season getBestSeason()
	{
		return bestSeason;
	}

	public Season getPreviousVersusSeason()
	{
		return previousVersusSeason;
	}
	
	public Season getBestVersusSeason()
	{
		return bestVersusSeason;
	}

	public Integer getLegendTrophies()
	{
	return legendTrophies;
	}
}
