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

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public IconUrls getIconUrls()
	{
		return iconUrls;
	}
}
