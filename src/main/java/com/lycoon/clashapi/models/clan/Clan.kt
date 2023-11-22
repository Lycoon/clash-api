package com.lycoon.clashapi.models.clan

import com.lycoon.clashapi.models.capital.ClanCapital
import com.lycoon.clashapi.models.clan.enums.InviteType
import com.lycoon.clashapi.models.clan.enums.WarFrequency
import com.lycoon.clashapi.models.common.BadgeUrls
import com.lycoon.clashapi.models.common.Label
import com.lycoon.clashapi.models.common.Language
import com.lycoon.clashapi.models.common.Location
import com.lycoon.clashapi.models.league.CapitalLeague
import com.lycoon.clashapi.models.warleague.WarLeague
import jdk.nashorn.internal.objects.annotations.Getter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Clan
(
    @SerialName("type")
    val inviteType: InviteType,

    @get:Getter(name = "isFamilyFriendly")
    val isFamilyFriendly: Boolean = false,
    val tag: String,
    val name: String,
    val clanLevel: Int = 0,
    val clanPoints: Int = 0,
    val description: String? = null,          // nullable when using clan search
    val chatLanguage: Language? = null,       // nullable when not set
    val labels: List<Label>,
    val location: Location? = null,           // nullable when using clan search
    val badgeUrls: BadgeUrls,
    val members: Int = 0,
    val memberList: List<ClanMember> = emptyList(), // nullable when using clan search

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

    @get:Getter(name = "isWarLogPublic")
    val isWarLogPublic: Boolean = false,
    val warLeague: WarLeague,
    val capitalLeague: CapitalLeague,
    val warFrequency: WarFrequency,
    val warWinStreak: Int = 0,
    val warWins: Int = 0,
    val warTies: Int = 0,
    val warLosses: Int = 0,
)