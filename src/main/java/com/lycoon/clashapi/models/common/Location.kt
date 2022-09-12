package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val localizedName: String? = null,
    val id: Int = 0,
    val name: String? = null,
    val isCountry: Boolean = false,
    val countryCode: String? = null // if isCountry false
)