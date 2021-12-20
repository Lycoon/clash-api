package com.lycoon.clashapi.old_models.clanwar.league;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Round
{
	@SerializedName("warTags")
	@Expose
	private List<String> warTags = null;
	
	/**
	 * Returns the tag of each war occurring during this round.
	 * 
	 * @return a <code>List</code> of String
	 */
	public List<String> getWarTags()
	{
		return warTags;
	}
}
