package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Clan(
    val warLeague: WarLeague,
    val memberList: List<WarMember>,
    val requiredTrophies: Int,
    val clanVersusPoints: Int,
    val tag: String,
    val isWarLogPublic: Boolean,
    val warFrequency: String,
    val clanLevel: Int,
    val warWinStreak: Int,
    val warWins: Int,
    val warTies: Int,
    val warLosses: Int,
    val clanPoints: Int,
    val chatLanguage: Language? = null,
    val labels: List<Label>,
    val name: String,
    val location: Location,
    val type: String,
    val members: Int,
    val description: String,
    val badgeUrls: BadgeUrls
)