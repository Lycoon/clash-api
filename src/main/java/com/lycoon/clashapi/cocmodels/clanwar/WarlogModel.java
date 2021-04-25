package com.lycoon.clashapi.cocmodels.clanwar;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WarlogModel
{
	@SerializedName("items")
	@Expose
	private List<WarlogItem> items = null;

	public List<WarlogItem> getWars()
	{
		return items;
	}
}
