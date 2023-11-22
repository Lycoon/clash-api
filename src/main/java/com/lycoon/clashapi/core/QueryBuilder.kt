package com.lycoon.clashapi.core

abstract class QueryParamsBuilder(
    open val limit: Int?     = null,
    open val after: String?  = null,
    open val before: String? = null,
) {
    open fun build(): String {
        append(builder, "limit", limit)
        append(builder, "after", after)
        append(builder, "before", before)

        return builder.toString()
    }

    companion object
    {
        fun <T> append(builder: StringBuilder, key: String, value: T)
        {
            if (value != null) {
                builder.append(if (builder.isEmpty()) "?" else "&")
                builder.append("$key=$value")
            }
        }
    }

    protected val builder = StringBuilder()
}

class ClanQueryParamsBuilder(
    override val limit: Int?     = null,
    override val after: String?  = null,
    override val before: String? = null,
    val name: String?            = null,
    val warFrequency: String?    = null,
    val locationId: Int?         = null,
    val minMembers: Int?         = null,
    val maxMembers: Int?         = null,
    val minClanPoints: Int?      = null,
    val minClanLevel: Int?       = null,
    val labelIds: String?        = null
) : QueryParamsBuilder(limit, after, before)
{
    override fun build(): String
    {
        append(builder, "name", name)
        append(builder, "warFrequency", warFrequency)
        append(builder, "locationId", locationId)
        append(builder, "minMembers", minMembers)
        append(builder, "maxMembers", maxMembers)
        append(builder, "minClanPoints", minClanPoints)
        append(builder, "minClanLevel", minClanLevel)
        append(builder, "labelIds", labelIds)

        return super.build()
    }
}

class SimpleQueryParamsBuilder(): QueryParamsBuilder(limit = null, after = "", before = "")
{}