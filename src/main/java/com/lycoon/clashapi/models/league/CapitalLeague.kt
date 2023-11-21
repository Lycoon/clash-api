package com.lycoon.clashapi.models.league

import kotlinx.serialization.Serializable

@Serializable
data class CapitalLeague(
        val name: String? = null,
        val id: Int? = 0
)