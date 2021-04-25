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

	@SerializedName("superTroopIsActive")
	@Expose
	private Boolean superTroopIsActive;
	
	/**
	 * Returns the current level of the troop.
	 * 
	 * @return an integer
	 */
	public Integer getLevel()
	{
		return level;
	}

	/**
	 * Returns the name of the troop.
	 * 
	 * @return a <code>String</code>
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the maximum level of upgrade possible for the troop.
	 * 
	 * @return an integer
	 */
	public Integer getMaxLevel()
	{
		return maxLevel;
	}
	
	/**
	 * Returns a <code>String</code> of the village name from which the troop comes from.
	 * 
	 * @return <code>home</code> if the troop is from the main village<br>
	 * <code>builderBase</code> if the troop is from the builder base
	 */
	public String getVillage()
	{
		return village;
	}

	/**
	 * Returns whether the super troop is active or not.
	 *
	 * @return a boolean
	 */
	public Boolean isActiveSuperTroop()
	{
		return superTroopIsActive;
	}
	
	@Override
	public String toString()
	{
		return name + " (level " +level+ "/" +maxLevel+ ") in " +village+ " village";
	}
}
