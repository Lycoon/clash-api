package com.lycoon.clashapi.core.auth.dtos

import kotlinx.serialization.Serializable

@Serializable
data class KeyCreation
(
    val name: String = "ClashAPI Key",
    val description: String = "This key has been automatically generated because an instance of ClashAPI has been created with these account credentials.",
    val cidrRanges: List<String>,
    val scopes: List<String>? = null
)
