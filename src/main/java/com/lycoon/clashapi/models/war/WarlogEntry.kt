package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class WarlogEntry(
    val clan: WarlogClan,
    val teamSize: Int,
    val opponent: WarlogClan,
    val endTime: String,
    val result: String? = null
)