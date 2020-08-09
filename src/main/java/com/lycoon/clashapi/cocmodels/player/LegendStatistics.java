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
	
	/**
	 * Returns the current season of the player in the main village.
	 * 
	 * @return a <code>Season</code> object - <b>null</b> if the player has not attacked in the main village during the current season
	 */
	public Season getCurrentSeason()
	{
		return currentSeason;
	}
	
	/**
	 * Returns the previous season of the player in the main village.
	 * 
	 * @return a <code>Season</code> object - <b>null</b> if the player has not attacked in the main village during the previous season
	 */
	public Season getPreviousSeason()
	{
		return previousSeason;
	}
	
	/**
	 * Returns the best season the player did in the main village.
	 * 
	 * @return a <code>Season</code> object
	 */
	public Season getBestSeason()
	{
		return bestSeason;
	}
	
	/**
	 * Returns the previous season of the player in the builder base.
	 * 
	 * @return a <code>Season</code> object - <b>null</b> if the player has not attacked in the builder base during the previous season
	 */
	public Season getPreviousVersusSeason()
	{
		return previousVersusSeason;
	}
	
	/**
	 * Returns the best season the player did in the builder base.
	 * 
	 * @return a <code>Season</code> object
	 */
	public Season getBestVersusSeason()
	{
		return bestVersusSeason;
	}

	/**
	 * Returns the number of trophies won in the Legend league.
	 * 
	 * @return an integer
	 */
	public Integer getLegendTrophies()
	{
		return legendTrophies;
	}
}
