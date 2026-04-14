@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.listitem.sample05_NavigationSuiteScaffold_NavigationRail_Expanded.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowDpSize
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import org.michaelbel.listitem.Tabs
import org.michaelbel.listitem.sample05_NavigationSuiteScaffold_NavigationRail_Expanded.main.about.AboutScreen
import org.michaelbel.listitem.sample05_NavigationSuiteScaffold_NavigationRail_Expanded.main.home.HomeScreen
import org.michaelbel.listitem.sample05_NavigationSuiteScaffold_NavigationRail_Expanded.main.settings.SettingsScreen

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }

    val navigationSuiteType = when {
        currentWindowDpSize().width >= 1200.dp -> NavigationSuiteType.WideNavigationRailExpanded
        else -> NavigationSuiteScaffoldDefaults.navigationSuiteType(currentWindowAdaptiveInfo())
    }
    val isNavigationRail = navigationSuiteType == NavigationSuiteType.WideNavigationRailCollapsed || navigationSuiteType == NavigationSuiteType.WideNavigationRailExpanded

    NavigationSuiteScaffold(
        navigationItems = {
            NavigationSuiteItem(
                selected = selectedTab == Tabs.Home,
                onClick = { selectedTab = Tabs.Home },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Home") },
                navigationSuiteType = navigationSuiteType
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
                label = { Text(text = "Settings") },
                navigationSuiteType = navigationSuiteType
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
                label = { Text(text = "About") },
                navigationSuiteType = navigationSuiteType
            )
        },
        navigationSuiteType = navigationSuiteType
    ) {
        when (selectedTab) {
            Tabs.Home -> {
                HomeScreen(
                    isNavigationRail = isNavigationRail,
                    onNavigateToDetails = onNavigateToDetails
                )
            }
            Tabs.Settings -> {
                SettingsScreen(
                    isNavigationRail = isNavigationRail
                )
            }
            Tabs.About -> {
                AboutScreen(
                    isNavigationRail = isNavigationRail
                )
            }
        }
    }
}
