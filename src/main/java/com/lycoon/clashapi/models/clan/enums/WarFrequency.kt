package com.lycoon.clashapi.models.clan.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WarFrequency {
    @SerialName("unknown") UNKNOWN,
    @SerialName("always") ALWAYS,
    @SerialName("moreThanOncePerWeek") MORE_THAN_ONCE_PER_WEEK,
    @SerialName("oncePerWeek") ONCE_PER_WEEK,
    @SerialName("lessThanOncePerWeek") LESS_THAN_ONCE_PER_WEEK,
    @SerialName("never") NEVER,
    @SerialName("any") ANY
}