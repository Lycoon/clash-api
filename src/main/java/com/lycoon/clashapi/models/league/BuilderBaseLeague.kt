package com.lycoon.clashapi.models.league

import kotlinx.serialization.Serializable

@Serializable
data class BuilderBaseLeague(
    val name: String? = null,
    val id: Int? = 0
)