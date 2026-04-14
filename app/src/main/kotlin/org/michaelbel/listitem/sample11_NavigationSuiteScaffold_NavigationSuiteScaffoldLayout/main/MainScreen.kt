@file:OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalWideNavigationRail
import androidx.compose.material3.Text
import androidx.compose.material3.WideNavigationRailItem
import androidx.compose.material3.WideNavigationRailValue
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowDpSize
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuite
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.material3.rememberWideNavigationRailState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.filled.Menu
import org.michaelbel.listitem.MenuOpen
import kotlinx.coroutines.launch
import org.michaelbel.listitem.Tabs
import org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.main.about.AboutScreen
import org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.main.home.HomeScreen
import org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.main.settings.SettingsScreen

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }

    val windowSize = currentWindowDpSize()
    val navigationSuiteType = when {
        windowSize.width >= 1200.dp -> NavigationSuiteType.WideNavigationRailExpanded
        windowSize.width >= 840.dp -> NavigationSuiteType.WideNavigationRailCollapsed
        windowSize.height < 480.dp -> NavigationSuiteType.ShortNavigationBarMedium
        else -> NavigationSuiteScaffoldDefaults.navigationSuiteType(currentWindowAdaptiveInfo())
    }
    val state = rememberNavigationSuiteScaffoldState()
    val scope = rememberCoroutineScope()
    val railState = rememberWideNavigationRailState()
    val railExpanded = railState.currentValue == WideNavigationRailValue.Expanded
    val useCustomCollapsedRail = navigationSuiteType == NavigationSuiteType.WideNavigationRailCollapsed
    val railToggle = @Composable {
        IconButton(
            modifier = Modifier.padding(start = 24.dp),
            onClick = { scope.launch { railState.toggle() } }
        ) {
            Icon(
                imageVector = if (railExpanded) MenuOpen else Icons.Filled.Menu,
                contentDescription = null
            )
        }
    }

    NavigationSuiteScaffoldLayout(
        navigationSuite = {
            when {
                useCustomCollapsedRail -> {
                    ModalWideNavigationRail(
                        state = railState,
                        header = railToggle,
                        expandedHeaderTopPadding = 56.dp
                    ) {
                        WideNavigationRailItem(
                            selected = selectedTab == Tabs.Home,
                            onClick = { selectedTab = Tabs.Home },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Home,
                                    contentDescription = null
                                )
                            },
                            label = { Text(text = "Home") },
                            railExpanded = railExpanded
                        )

                        WideNavigationRailItem(
                            selected = selectedTab == Tabs.Settings,
                            onClick = { selectedTab = Tabs.Settings },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Settings,
                                    contentDescription = null
                                )
                            },
                            label = { Text(text = "Settings") },
                            railExpanded = railExpanded
                        )

                        WideNavigationRailItem(
                            selected = selectedTab == Tabs.About,
                            onClick = { selectedTab = Tabs.About },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = null
                                )
                            },
                            label = { Text(text = "About") },
                            railExpanded = railExpanded
                        )
                    }
                }
                else -> {
                    NavigationSuite(
                        navigationSuiteType = navigationSuiteType
                    ) {
                        NavigationSuiteItem(
                            navigationSuiteType = navigationSuiteType,
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
                            navigationSuiteType = navigationSuiteType,
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
                            navigationSuiteType = navigationSuiteType,
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
                }
            }
        },
        navigationSuiteType = navigationSuiteType,
        state = state
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
