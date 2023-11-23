package com.lycoon.clashapi.core.auth.dtos

import kotlinx.serialization.Serializable

@Serializable
data class TokenValidationResponse
(
    val tag: String,
    val token: String,
    val status: String
)
