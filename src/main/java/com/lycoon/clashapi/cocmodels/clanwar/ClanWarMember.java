package com.lycoon.clashapi.cocmodels.clanwar;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClanWarMember
{
	@SerializedName("tag")
	@Expose
	private String tag;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("mapPosition")
	@Expose
	private Integer mapPosition;
	
	@SerializedName("townhallLevel")
	@Expose
	private Integer townhallLevel;
	
	@SerializedName("opponentAttacks")
	@Expose
	private Integer opponentAttacks;
	
	@SerializedName("bestOpponentAttack")
	@Expose
	private Attack bestOpponentAttack;
	
	@SerializedName("attacks")
	@Expose
	private List<Attack> attacks = null;

	public String getTag()
	{
		return tag;
	}

	public String getName()
	{
		return name;
	}

	public Integer getMapPosition()
	{
		return mapPosition;
	}
	
	public Integer getTownhallLevel()
	{
		return townhallLevel;
	}

	public Integer getOpponentAttacks()
	{
		return opponentAttacks;
	}

	public Attack getBestOpponentAttack()
	{
		return bestOpponentAttack;
	}

	public List<Attack> getAttacks()
	{
		return attacks;
	}
}
