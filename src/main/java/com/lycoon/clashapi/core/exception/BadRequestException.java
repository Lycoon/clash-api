package com.lycoon.clashapi.core.exception;

/**
 * Thrown if incorrect parameters are given to the request
 */
public class BadRequestException extends ClashAPIException
{
	private static final long serialVersionUID = 7825222581390642435L;

	public BadRequestException(String message) 
    {
        super(message);
    }
}
