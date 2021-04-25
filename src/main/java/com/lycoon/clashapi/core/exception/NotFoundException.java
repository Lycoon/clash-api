package com.lycoon.clashapi.core.exception;

/**
 * Thrown when the requested URL is not found
 */
public class NotFoundException extends ClashAPIException
{
	private static final long serialVersionUID = 7251768343247643633L;
	
	public NotFoundException() {
        super("404");
    }
}
