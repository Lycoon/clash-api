package com.lycoon.clashapi.core.exception

/**
 * Thrown if the request couldn't be executed because of Clash of Clans undergoing maintenance
 */
class MaintenanceException : ClashAPIException("503")