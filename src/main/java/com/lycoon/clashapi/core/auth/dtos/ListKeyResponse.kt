package com.lycoon.clashapi.core.auth.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ListKeyResponse
(
    val keys: List<Key>
)
