package com.lycoon.clashapi.old_models.clan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location
{
	@SerializedName("id")
	@Expose
	private Integer id;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("isCountry")
	@Expose
	private Boolean isCountry;
	
	@SerializedName("countryCode")
	@Expose
	private String countryCode;

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public Boolean getIsCountry()
	{
		return isCountry;
	}

	public String getCountryCode()
	{
		return countryCode;
	}
}
