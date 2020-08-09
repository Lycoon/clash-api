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
	
	/**
	 * Returns a link to a 72x72 resolution icon.
	 * 
	 * @return a <code>String</code>
	 */
	public String getSmall()
	{
		return small;
	}
	
	/**
	 * Returns a link to a 36x36 resolution icon.
	 * 
	 * @return a <code>String</code>
	 */
	public String getTiny()
	{
		return tiny;
	}
	
	/**
	 * Returns a link to a 288x288 resolution icon.
	 * 
	 * @return a <code>String</code>
	 */
	public String getMedium()
	{
		return medium;
	}
}
