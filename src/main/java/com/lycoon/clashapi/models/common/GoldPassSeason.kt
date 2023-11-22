package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class GoldPassSeason (
    val startTime: String? = null,
    val endTime: String? = null
)