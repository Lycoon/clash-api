package com.lycoon.clashapi.cocmodels.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Troop
{
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("level")
	@Expose
	private Integer level;
	
	@SerializedName("maxLevel")
	@Expose
	private Integer maxLevel;
	
	@SerializedName("village")
	@Expose
	private String village;
	
	/**
	 * Returns the current level of the concerned troop, spell or hero.
	 * 
	 * @return an integer corresponding to the level of the troop
	 */
	public Integer getLevel()
	{
		return level;
	}

	/**
	 * Returns the name of the concerned troop, spell or hero.
	 * 
	 * @return a string corresponding to the name of the troop
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the maximum level of upgrade in the game for the concerned troop, spell or hero.
	 * 
	 * @return an integer corresponding to the maximum level of upgrade for the troop
	 */
	public Integer getMaxLevel()
	{
		return maxLevel;
	}
	
	/**
	 * Returns <code>home</code> if the troop is from the main village.<br>
	 * Or returns <code>builderBase</code> if it is from the builder base.
	 * 
	 * @return a string corresponding to the village to which the troop is attached
	 */
	public String getVillage()
	{
		return village;
	}
	
	@Override
	public String toString()
	{
		return name + " (level " +level+ "/" +maxLevel+ ") in " +village+ " village";
	}
}
