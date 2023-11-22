package com.lycoon.clashapi.models.warleague

import kotlinx.serialization.Serializable

@Serializable
data class WarLeague(
    val name: String? = null,
    val id: Int = 0
)