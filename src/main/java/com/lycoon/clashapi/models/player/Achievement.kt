package com.lycoon.clashapi.models.player

import kotlinx.serialization.Serializable

@Serializable
data class Achievement(
    val stars: Int = 0,
    val value: Int = 0,
    val name: String? = null,
    val target: Int = 0,
    val info: String? = null,
    val completionInfo: String? = null,
    val village: String? = null
)