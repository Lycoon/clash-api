package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.player.enums.Village
import kotlinx.serialization.Serializable

@Serializable
data class Achievement
(
    val stars: Int,
    val value: Int,
    val name: String,
    val target: Int,
    val info: String,
    val completionInfo: String? = null, // nullable
    val village: Village
)