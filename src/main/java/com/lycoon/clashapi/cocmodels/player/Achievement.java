package com.lycoon.clashapi.cocmodels.player;

import java.text.NumberFormat;
import java.util.Locale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Achievement
{
	@SerializedName("stars")
	@Expose
	private Integer stars;
	
	@SerializedName("value")
	@Expose
	private Integer value;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("target")
	@Expose
	private Integer target;
	
	@SerializedName("info")
	@Expose
	private String info;
	
	@SerializedName("completionInfo")
	@Expose
	private String completionInfo;
	
	@SerializedName("village")
	@Expose
	private String village;
	
	/**
	 * Returns how many stars the player has scored for this achievement.
	 * 
	 * @return an integer
	 */
	public Integer getStars()
	{
		return stars;
	}
	
	/**
	 * Returns the current value of the achievement.
	 * 
	 * @return an integer
	 */
	public Integer getValue()
	{
		return value;
	}
	
	/**
	 * Returns the name of the achievement.
	 * 
	 * @return a <code>String</code>
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the target value to earn the next new star.
	 * 
	 * @return an integer
	 */
	public Integer getTarget()
	{
		return target;
	}
	
	/**
	 * Returns the description of the achievement.
	 * 
	 * @return a <code>String</code>
	 */
	public String getInfo()
	{
		return info;
	}
	
	/**
	 * Returns additional info about the achievement.
	 * 
	 * @return a <code>String</code> - <b>null</b> if there is no additional info
	 */
	public String getCompletionInfo()
	{
		return completionInfo;
	}
	
	/**
	 * Returns a <code>String</code> of the village from which the achievement comes from.
	 * 
	 * @return <code>home</code> if the achievement concerns the main village<br>
	 * <code>builderBase</code> if the achievement concerns the builder base
	 */
	public String getVillage()
	{
		return village;
	}
	
	@Override
	public String toString()
	{
		NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
		return "[" +name+ "] " +info+ "\n"
				+ "  ├ " +nf.format(value)+ " / " +nf.format(target)+ " with " +stars+ " stars in " +village+ " village\n"
				+ "  └ " +completionInfo;
	}
}
