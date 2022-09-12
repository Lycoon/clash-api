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
    val requiredVersusTrophies: Int = 0,
    val requiredTownhallLevel: Int = 0,
    val requiredTrophies: Int = 0,
    val clanVersusPoints: Int = 0,
    val tag: String,
    val isWarLogPublic: Boolean,
    val warFrequency: String, // UNKNOWN, ALWAYS, MORE_THAN_ONCE_PER_WEEK, ONCE_PER_WEEK, LESS_THAN_ONCE_PER_WEEK, NEVER, ANY
    val clanLevel: Int = 0,
    val warWinStreak: Int = 0,
    val warWins: Int = 0,
    val warTies: Int = 0,
    val warLosses: Int = 0,
    val clanPoints: Int = 0,
    val chatLanguage: Language? = null,
    val labels: List<Label>,
    val name: String,
    val location: Location? = null,
    val type: String,
    val members: Int = 0,
    val description: String,
    val badgeUrls: BadgeUrls
)