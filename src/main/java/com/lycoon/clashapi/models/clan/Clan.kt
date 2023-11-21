package com.lycoon.clashapi.models.clan

import com.lycoon.clashapi.models.capital.ClanCapital
import com.lycoon.clashapi.models.clan.enums.InviteType
import com.lycoon.clashapi.models.clan.enums.WarFrequency
import com.lycoon.clashapi.models.common.BadgeUrls
import com.lycoon.clashapi.models.common.Label
import com.lycoon.clashapi.models.common.Language
import com.lycoon.clashapi.models.common.Location
import com.lycoon.clashapi.models.league.CapitalLeague
import com.lycoon.clashapi.models.war.WarMember
import com.lycoon.clashapi.models.warleague.WarLeague
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Clan
(
    @SerialName("type")
    val inviteType: InviteType,

    val tag: String,
    val name: String,
    val clanLevel: Int = 0,
    val clanPoints: Int = 0,
    val description: String? = null,          // nullable when using clan search
    val isFamilyFriendly: Boolean = false,
    val chatLanguage: Language? = null,
    val labels: List<Label>,
    val location: Location? = null,
    val badgeUrls: BadgeUrls? = null,
    val members: Int = 0,
    val memberList: List<ClanMember>? = null, // nullable when using clan search

    @Deprecated("Use requiredBuilderBaseTrophies instead")
    val requiredVersusTrophies: Int = 0,
    val requiredBuilderBaseTrophies: Int = 0,
    val requiredTrophies: Int = 0,
    val requiredTownhallLevel: Int = 0,

    @Deprecated("Use clanBuilderBasePoints instead")
    val clanVersusPoints: Int = 0,
    val clanBuilderBasePoints: Int = 0,
    val clanCapitalPoints: Int = 0,
    val clanCapital: ClanCapital? = null,     // nullable if clan has no capital

    val warLeague: WarLeague,
    val capitalLeague: CapitalLeague,
    val isWarLogPublic: Boolean = false,
    val warFrequency: WarFrequency,
    val warWinStreak: Int = 0,
    val warWins: Int = 0,
    val warTies: Int = 0,
    val warLosses: Int = 0,
)