package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Achievement(
    val stars: Int,
    val value: Int,
    val name: String,
    val target: Int,
    val info: String,
    val completionInfo: String,
    val village: String
)