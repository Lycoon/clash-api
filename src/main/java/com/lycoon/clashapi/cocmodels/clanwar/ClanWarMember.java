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
	
	/**
	 * Returns the tag of the clan member involved in this war.<br><br>
	 * The tag is a unique identifier each player has, in the form of #AAAA00.<br>
	 * It is displayed under the nickname on player's profile.
	 * 
	 * @return a <code>String</code>
	 */
	public String getTag()
	{
		return tag;
	}
	
	/**
	 * Returns the name of the clan member involved in this war.<br>
	 * The name is the identity behind which you appear when you write in chat.
	 * 
	 * @return a <code>String</code>
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the position at which the clan war member is in the map.
	 * 
	 * @return an integer
	 */
	public Integer getMapPosition()
	{
		return mapPosition;
	}
	
	/**
	 * Returns the current level of the clan war member's townhall.<br><br>
	 * Ranges from <code>1</code> to <code>13</code>.
	 * 
	 * @return an integer
	 */
	public Integer getTownhallLevel()
	{
		return townhallLevel;
	}
	
	/**
	 * Returns how many of his attacks the clan war member did.
	 * 
	 * @return an integer
	 */
	public Integer getOpponentAttacks()
	{
		return opponentAttacks;
	}
	
	/**
	 * Returns the best attack the clan war member did.
	 * 
	 * @return an <code>Attack</code> object
	 * @see Attack
	 */
	public Attack getBestOpponentAttack()
	{
		return bestOpponentAttack;
	}
	
	/**
	 * Returns the attacks the clan war member did.
	 * 
	 * @return a <code>List</code> of <code>Attack</code> objects
	 * @see Attack
	 */
	public List<Attack> getAttacks()
	{
		return attacks;
	}
}
