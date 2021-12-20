package com.lycoon.clashapi.core.exception

import java.lang.Exception

/**
 * Parent class for ClashAPI exceptions
 */
open class ClashAPIException(message: String) : Exception(message)