package com.lycoon.clashapi.core.auth.dtos

import kotlinx.serialization.Serializable

@Serializable
data class Key
(
    val name: String,
    val description: String,
    val cidrRanges: List<String>,
    val key: String
)
