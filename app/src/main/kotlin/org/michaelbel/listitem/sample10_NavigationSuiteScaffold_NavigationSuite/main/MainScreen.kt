@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.listitem.sample10_NavigationSuiteScaffold_NavigationSuite.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuite
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.michaelbel.listitem.Tabs
import org.michaelbel.listitem.sample10_NavigationSuiteScaffold_NavigationSuite.main.about.AboutScreen
import org.michaelbel.listitem.sample10_NavigationSuiteScaffold_NavigationSuite.main.home.HomeScreen
import org.michaelbel.listitem.sample10_NavigationSuiteScaffold_NavigationSuite.main.settings.SettingsScreen

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        NavigationSuite(
            navigationSuiteType = NavigationSuiteType.WideNavigationRailCollapsed
        ) {
            NavigationSuiteItem(
                selected = selectedTab == Tabs.Home,
                onClick = { selectedTab = Tabs.Home },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Home") }
            )

            NavigationSuiteItem(
                selected = selectedTab == Tabs.Settings,
                onClick = { selectedTab = Tabs.Settings },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Settings") }
            )

            NavigationSuiteItem(
                selected = selectedTab == Tabs.About,
                onClick = { selectedTab = Tabs.About },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null
                    )
                },
                label = { Text(text = "About") }
            )
        }

        Box(
            modifier = Modifier.weight(1F)
        ) {
            when (selectedTab) {
                Tabs.Home -> {
                    HomeScreen(
                        onNavigateToDetails = onNavigateToDetails
                    )
                }
                Tabs.Settings -> SettingsScreen()
                Tabs.About -> AboutScreen()
            }
        }
    }
}
