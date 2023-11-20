package com.lycoon.clashapi.core

data class BaseQuery(
    val limit: Int = 0,
    val after: String? = null,
    val before: String? = null,
)

data class ClanQuery(
    val limit: Int = 0,
    val after: String? = null,
    val before: String? = null,

    val name: String? = null,
    val warFrequency: String? = null,
    val locationId: Int = 0,
    val minMembers: Int = 0,
    val maxMembers: Int = 0,
    val minClanPoints: Int = 0,
    val minClanLevel: Int = 0,
    val labelIds: String? = null
)