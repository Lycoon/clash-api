package com.lycoon.clashapi.cocmodels.clan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClanMember
{
	@SerializedName("tag")
	@Expose
	private String tag;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("role")
	@Expose
	private String role;
	
	@SerializedName("expLevel")
	@Expose
	private Integer expLevel;
	
	@SerializedName("league")
	@Expose
	private Label league;
	
	@SerializedName("trophies")
	@Expose
	private Integer trophies;
	
	@SerializedName("versusTrophies")
	@Expose
	private Integer versusTrophies;
	
	@SerializedName("clanRank")
	@Expose
	private Integer clanRank;
	
	@SerializedName("previousClanRank")
	@Expose
	private Integer previousClanRank;
	
	@SerializedName("donations")
	@Expose
	private Integer donations;
	
	@SerializedName("donationsReceived")
	@Expose
	private Integer donationsReceived;

	public String getTag()
	{
		return tag;
	}

	public String getName()
	{
		return name;
	}

	public String getRole()
	{
		return role;
	}

	public Integer getExpLevel()
	{
		return expLevel;
	}

	public Label getLeague()
	{
		return league;
	}

	public Integer getTrophies()
	{
		return trophies;
	}

	public Integer getVersusTrophies()
	{
		return versusTrophies;
	}

	public Integer getClanRank()
	{
		return clanRank;
	}

	public Integer getPreviousClanRank()
	{
		return previousClanRank;
	}

	public Integer getDonations()
	{
		return donations;
	}

	public Integer getDonationsReceived()
	{
		return donationsReceived;
	}
}
