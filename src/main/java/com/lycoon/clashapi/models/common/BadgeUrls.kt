package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class BadgeUrls(val small: String? = null, val medium: String? = null, val large: String? = null)