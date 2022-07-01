package com.lycoon.clashapi.models.clan

import com.lycoon.clashapi.models.common.BadgeUrls
import com.lycoon.clashapi.models.common.Label
import com.lycoon.clashapi.models.common.Language
import com.lycoon.clashapi.models.common.Location
import com.lycoon.clashapi.models.war.WarMember
import com.lycoon.clashapi.models.warleague.WarLeague
import kotlinx.serialization.Serializable

@Serializable
data class Clan(
    val warLeague: WarLeague,
    val memberList: List<ClanMember>,
    val requiredVersusTrophies: Int,
    val requiredTownhallLevel: Int,
    val requiredTrophies: Int,
    val clanVersusPoints: Int,
    val tag: String,
    val isWarLogPublic: Boolean,
    val warFrequency: String,
    val clanLevel: Int,
    val warWinStreak: Int,
    val warWins: Int?,
    val warTies: Int?,
    val warLosses: Int,
    val clanPoints: Int,
    val chatLanguage: Language? = null,
    val labels: List<Label>,
    val name: String,
    val location: Location? = null,
    val type: String,
    val members: Int,
    val description: String,
    val badgeUrls: BadgeUrls
)