package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class LegendSeasonResult(val trophies: Int, val id: String, val rank: Int)