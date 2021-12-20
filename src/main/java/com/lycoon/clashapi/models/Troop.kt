package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Troop(
    val level: Int,
    val name: String,
    val maxLevel: String,
    val village: String,
    val superTroopIsActive: Boolean? = false
)