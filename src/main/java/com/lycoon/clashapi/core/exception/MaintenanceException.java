package com.lycoon.clashapi.core.exception;

/**
 * Thrown if the request couldn't be executed because of Clash of Clans undergoing maintenance
 */
public class MaintenanceException extends ClashAPIException
{
	private static final long serialVersionUID = -4588968292458930870L;

	public MaintenanceException(String message) 
    {
        super(message);
    }
}
