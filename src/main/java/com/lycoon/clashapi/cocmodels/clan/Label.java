package com.lycoon.clashapi.cocmodels.clan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Label
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
	 * Returns the id of the label.
	 * 
	 * @return an integer
	 */
	public Integer getId()
	{
		return id;
	}
	
	/**
	 * Returns the name of the label.
	 * 
	 * @return a <code>String</code>
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the icon of the label in 3 different sizes.
	 * 
	 * @return a <code>IconUrls</code> object
	 * @see IconUrls
	 */
	public IconUrls getIconUrls()
	{
		return iconUrls;
	}
}
