package com.lycoon.clashapi.core.exception;

/**
 * Thrown if an unknown error occurs
 */
public class UnknownException extends ClashAPIException
{
	private static final long serialVersionUID = 1916833045937890576L;

	public UnknownException() {
        super("500");
    }
}
