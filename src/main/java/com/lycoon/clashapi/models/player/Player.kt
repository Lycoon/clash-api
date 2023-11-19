package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.common.Label
import com.lycoon.clashapi.models.league.BuilderBaseLeague
import com.lycoon.clashapi.models.league.League
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val league: League? = null,
    val builderBaseLeague: BuilderBaseLeague? = null,
    val clan: PlayerClan? = null,
    val role: Role,
    val warPreference: WarPreference,
    val attackWins: Int = 0,
    val defenseWins: Int = 0,
    val versusTrophies: Int = 0,
    val bestVersusTrophies: Int = 0,
    val townHallLevel: Int = 0,
    val townHallWeaponLevel: Int = 0,
    val versusBattleWins: Int = 0,
    val legendStatistics: PlayerLegendStatistics? = null,
    val troops: List<Troop>,
    val heroes: List<Troop>,
    val spells: List<Troop>,
    val labels: List<Label>,
    val tag: String? = null,
    val name: String? = null,
    val expLevel: Int = 0,
    val trophies: Int = 0,
    val bestTrophies: Int = 0,
    val donations: Int = 0,
    val donationsReceived: Int = 0,
    val builderHallLevel: Int = 0,
    val builderBaseTrophies: Int = 0,
    val bestBuilderBaseTrophies: Int = 0,
    val warStars: Int = 0,
    val clanCapitalContributions: Int? = 0,
    val achievements: List<Achievement>,
    val playerHouse: PlayerHouse
) {
    enum class Role { NOT_MEMBER, MEMBER, LEADER, ADMIN, COLEADER }
    enum class WarPreference { OUT, IN }
    enum class VillageType { HOME_VILLAGE, BUILDER_BASE, CLAN_CAPITAL }
}