package com.lycoon.clashapi.cocmodels.player;

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

	public Integer getStars()
	{
		return stars;
	}

	public Integer getValue()
	{
		return value;
	}

	public String getName()
	{
		return name;
	}

	public Integer getTarget()
	{
		return target;
	}
	
	public String getInfo()
	{
		return info;
	}
	
	public String getCompletionInfo()
	{
		return completionInfo;
	}

	public String getVillage()
	{
		return village;
	}
}
