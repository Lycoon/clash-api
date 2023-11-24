package com.lycoon.clashapi.core.auth.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Key
(
    val name: String,
    val description: String,
    @SerialName("cidrRanges") val ips: List<String>,
    @SerialName("key") val token: String
)
