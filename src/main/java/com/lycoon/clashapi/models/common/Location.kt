package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val localizedName: String? = null,
    val id: Int,
    val name: String,
    val isCountry: Boolean,
    val countryCode: String? = null // if isCountry false
)