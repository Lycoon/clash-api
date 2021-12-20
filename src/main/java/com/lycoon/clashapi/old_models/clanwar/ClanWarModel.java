package com.lycoon.clashapi.old_models.clanwar;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lycoon.clashapi.old_models.clan.BadgeUrls;

public class ClanWarModel
{
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
	
	@SerializedName("destructionPercentage")
	@Expose
	private Double destructionPercentage;
	
	@SerializedName("expEarned")
	@Expose
	private Integer expEarned;
	
	@SerializedName("members")
	@Expose
	private List<ClanWarMember> members = null;
	
	/**
	 * Returns the percentage of how much this clan destroyed its enemy clan.<br><br>
	 * Ranges from <code>0</code> to <code>100</code>.
	 * 
	 * @return a double
	 */
	public Double getDestructionPercentage()
	{
		return destructionPercentage;
	}
	
	/**
	 * Returns the tag of the clan involved in the clan war.<br><br>
	 * The tag is a unique identifier each clan has, in the form of #AAAA00.<br>
	 * It is displayed under the clan name on clan's profile.
	 * 
	 * @return a <code>String</code>
	 */
	public String getTag()
	{
		return tag;
	}
	
	/**
	 * Returns the name of the clan involved in the clan war.
	 * 
	 * @return a <code>String</code>
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the badge links of the clan.
	 * 
	 * @return a <code>BadgeUrls</code> object
	 * @see BadgeUrls
	 */
	public BadgeUrls getBadgeUrls()
	{
		return badgeUrls;
	}
	
	/**
	 * Returns the current experience level of the clan.
	 * 
	 * @return an integer
	 */
	public Integer getClanLevel()
	{
		return clanLevel;
	}
	
	/**
	 * Returns the total number of attacks the clan members of the war did.
	 * 
	 * @return an integer
	 */
	public Integer getAttacks()
	{
		return attacks;
	}
	
	/**
	 * Returns the total number of stars the clan members of the war earned.
	 * 
	 * @return an integer
	 */
	public Integer getStars()
	{
		return stars;
	}
	
	/**
	 * Returns how many experience points the clan earned during the war.
	 * 
	 * @return an integer
	 */
	public Integer getExpEarned()
	{
		return expEarned;
	}
	
	/**
	 * Returns the members of this clan involved in the war.
	 * 
	 * @return a <code>List</code> of <code>ClanWarMember</code objects
	 * @see ClanWarMember
	 */
	public List<ClanWarMember> getWarMembers()
	{
		return members;
	}
}
