package com.lycoon.clashapi.core.exceptions

import java.lang.Exception

/**
 * Parent class for ClashAPI exceptions
 */
open class ClashAPIException(message: String) : Exception(message)