package org.michaelbel.listitem

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute: NavKey {

    @Serializable
    data object Home: AppRoute

    @Serializable
    data class Details(val boarId: Int): AppRoute
}

sealed interface Tabs {

    @Serializable
    data object Home: Tabs

    @Serializable
    data object Settings: Tabs

    @Serializable
    data object About: Tabs

    companion object {
        val Saver: Saver<Tabs, Int> = Saver(
            save = { tab ->
                when (tab) {
                    Home -> 0
                    Settings -> 1
                    About -> 2
                }
            },
            restore = { index ->
                when (index) {
                    1 -> Settings
                    2 -> About
                    else -> Home
                }
            }
        )
    }
}
