package com.lycoon.clashapi.core.exceptions

/**
 * Thrown when too many requests are made to the game API within a certain period
 */
class RateLimitException : ClashAPIException("429")