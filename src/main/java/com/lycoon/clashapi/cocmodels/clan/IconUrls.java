package com.lycoon.clashapi.cocmodels.clan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IconUrls 
{
	@SerializedName("small")
	@Expose
	private String small;
	
	@SerializedName("tiny")
	@Expose
	private String tiny;
	
	@SerializedName("medium")
	@Expose
	private String medium;

	public String getSmall()
	{
		return small;
	}

	public String getTiny()
	{
		return tiny;
	}

	public String getMedium()
	{
		return medium;
	}
}
