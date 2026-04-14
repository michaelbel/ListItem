@file:OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem.sample09_NavigationSuiteScaffold_Colors.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShortNavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.WideNavigationRailDefaults
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowDpSize
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.michaelbel.listitem.AppSettings
import org.michaelbel.listitem.Tabs
import org.michaelbel.listitem.sample09_NavigationSuiteScaffold_Colors.main.about.AboutScreen
import org.michaelbel.listitem.sample09_NavigationSuiteScaffold_Colors.main.home.HomeScreen
import org.michaelbel.listitem.sample09_NavigationSuiteScaffold_Colors.main.settings.SettingsScreen

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }
    val customColorsEnabled by AppSettings.customNavigationColorsFlow.collectAsStateWithLifecycle()

    val navigationSuiteType = when {
        currentWindowDpSize().width >= 1200.dp -> NavigationSuiteType.WideNavigationRailExpanded
        else -> NavigationSuiteScaffoldDefaults.navigationSuiteType(currentWindowAdaptiveInfo())
    }
    val isNavigationRail = navigationSuiteType == NavigationSuiteType.WideNavigationRailCollapsed
            || navigationSuiteType == NavigationSuiteType.WideNavigationRailExpanded

    val navigationSuiteColors = when {
        customColorsEnabled -> {
            NavigationSuiteDefaults.colors(
                shortNavigationBarContainerColor = MaterialTheme.colorScheme.primaryContainer,
                shortNavigationBarContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                wideNavigationRailColors = WideNavigationRailDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                navigationBarContainerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationBarContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationRailContainerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationRailContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        else -> NavigationSuiteDefaults.colors()
    }
    val containerColor = if (customColorsEnabled) MaterialTheme.colorScheme.tertiaryContainer else NavigationSuiteScaffoldDefaults.containerColor
    val contentColor = if (customColorsEnabled) MaterialTheme.colorScheme.onTertiaryContainer else NavigationSuiteScaffoldDefaults.contentColor
    val navigationItemColors = when {
        customColorsEnabled -> {
            ShortNavigationBarItemDefaults.colors(
                selectedIndicatorColor = MaterialTheme.colorScheme.primary,
                selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unselectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        else -> null
    }
    val scaffoldContainerColor = if (customColorsEnabled) Color.Transparent else MaterialTheme.colorScheme.background

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
                navigationSuiteType = navigationSuiteType,
                colors = navigationItemColors
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
                navigationSuiteType = navigationSuiteType,
                colors = navigationItemColors
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
                navigationSuiteType = navigationSuiteType,
                colors = navigationItemColors
            )
        },
        navigationSuiteType = navigationSuiteType,
        navigationSuiteColors = navigationSuiteColors,
        containerColor = containerColor,
        contentColor = contentColor
    ) {
        when (selectedTab) {
            Tabs.Home -> {
                HomeScreen(
                    isNavigationRail = isNavigationRail,
                    scaffoldContainerColor = scaffoldContainerColor,
                    onNavigateToDetails = onNavigateToDetails
                )
            }
            Tabs.Settings -> {
                SettingsScreen(
                    isNavigationRail = isNavigationRail,
                    scaffoldContainerColor = scaffoldContainerColor
                )
            }
            Tabs.About -> {
                AboutScreen(
                    isNavigationRail = isNavigationRail,
                    scaffoldContainerColor = scaffoldContainerColor
                )
            }
        }
    }
}
