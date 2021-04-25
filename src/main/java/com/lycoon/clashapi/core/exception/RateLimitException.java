package com.lycoon.clashapi.core.exception;

/**
 * Thrown when too many requests are made to the game API within a certain period
 */
public class RateLimitException extends ClashAPIException
{
	private static final long serialVersionUID = 5756968002969597017L;

	public RateLimitException() {
        super("429");
    }
}
