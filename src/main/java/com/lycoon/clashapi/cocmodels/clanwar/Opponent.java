package com.lycoon.clashapi.cocmodels.clanwar;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lycoon.clashapi.cocmodels.clan.BadgeUrls;

public class Opponent
{
	@SerializedName("destructionPercentage")
	@Expose
	private String destructionPercentage;
	
	@SerializedName("tag")
	@Expose
	private String tag;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("badgeUrls")
	@Expose
	private BadgeUrls badgeUrls;
	
	@SerializedName("clanLevel")
	@Expose
	private Integer clanLevel;
	
	@SerializedName("attacks")
	@Expose
	private Integer attacks;
	
	@SerializedName("stars")
	@Expose
	private Integer stars;
	
	@SerializedName("expEarned")
	@Expose
	private Integer expEarned;
	
	@SerializedName("members")
	@Expose
	private List<ClanWarMember> members = null;

	public String getDestructionPercentage()
	{
		return destructionPercentage;
	}

	public String getTag()
	{
		return tag;
	}
	
	public String getName()
	{
		return name;
	}

	public BadgeUrls getBadgeUrls()
	{
		return badgeUrls;
	}

	public Integer getClanLevel()
	{
		return clanLevel;
	}

	public Integer getAttacks()
	{
		return attacks;
	}

	public Integer getStars()
	{
		return stars;
	}

	public Integer getExpEarned()
	{
		return expEarned;
	}

	public List<ClanWarMember> getMembers()
	{
		return members;
	}
}
