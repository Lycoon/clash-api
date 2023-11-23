package com.lycoon.clashapi.core.auth.dtos

import kotlinx.serialization.Serializable

@Serializable
data class Credentials
(
    val email: String,
    val password: String
)
