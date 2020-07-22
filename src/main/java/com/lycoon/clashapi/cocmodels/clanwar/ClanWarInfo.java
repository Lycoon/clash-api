package com.lycoon.clashapi.cocmodels.clanwar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClanWarInfo
{
	@SerializedName("clan")
	@Expose
	private Opponent clan;
	
	@SerializedName("teamSize")
	@Expose
	private Integer teamSize;
	
	@SerializedName("opponent")
	@Expose
	private Opponent opponent;
	
	@SerializedName("startTime")
	@Expose
	private String startTime;
	
	@SerializedName("state")
	@Expose
	private String state;
	
	@SerializedName("endTime")
	@Expose
	private String endTime;
	
	@SerializedName("preparationStartTime")
	@Expose
	private String preparationStartTime;

	public Opponent getClan()
	{
		return clan;
	}

	public Integer getTeamSize()
	{
		return teamSize;
	}

	public Opponent getOpponent()
	{
		return opponent;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public String getState()
	{
		return state;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public String getPreparationStartTime()
	{
		return preparationStartTime;
	}
}
