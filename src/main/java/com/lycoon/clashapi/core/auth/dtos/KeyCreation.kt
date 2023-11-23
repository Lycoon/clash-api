package com.lycoon.clashapi.core.auth.dtos

import kotlinx.serialization.Serializable

@Serializable
data class KeyCreation
(
    val name: String,
    val description: String,
    val cidrRanges: List<String>,
    val scopes: List<String> = listOf("clash")
)
