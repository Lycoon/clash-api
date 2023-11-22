package com.lycoon.clashapi.models.league

import kotlinx.serialization.Serializable

@Serializable
data class BuilderBaseLeague
(
    val id: Int = 0,
    val name: String? = null,
)