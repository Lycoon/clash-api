package com.lycoon.clashapi.old_models.clan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BadgeUrls
{
	@SerializedName("small")
	@Expose
	private String small;
	
	@SerializedName("large")
	@Expose
	private String large;
	
	@SerializedName("medium")
	@Expose
	private String medium;

	public String getSmall()
	{
		return small;
	}

	public String getLarge()
	{
		return large;
	}

	public String getMedium()
	{
		return medium;
	}
}
