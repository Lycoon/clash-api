package com.lycoon.clashapi.cocmodels.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lycoon.clashapi.cocmodels.clan.IconUrls;

public class League
{
	@SerializedName("id")
	@Expose
	private Integer id;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("iconUrls")
	@Expose
	private IconUrls iconUrls;
	
	/**
	 * Returns the id of the league.
	 * 
	 * @return an integer
	 */
	public Integer getId()
	{
		return id;
	}
	
	/**
	 * Returns the name of the league where the player is currently in.
	 * 
	 * @return a <code>String</code>
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the icon of the league in 3 different sizes.
	 * 
	 * @return a <code>IconUrls</code> object
	 * @see IconUrls
	 */
	public IconUrls getIconUrls()
	{
		return iconUrls;
	}
}
