package com.lycoon.clashapi.core.exception;

/**
 * Parent class for ClashAPI exceptions
 */
public class ClashAPIException extends Exception
{
	private static final long serialVersionUID = 4796823785326521342L;

	public ClashAPIException(String message)
	{
		super(message);
	}
}
