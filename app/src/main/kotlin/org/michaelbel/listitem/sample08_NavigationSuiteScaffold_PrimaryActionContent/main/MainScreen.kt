@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.listitem.sample08_NavigationSuiteScaffold_PrimaryActionContent.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.michaelbel.listitem.AppSettings
import org.michaelbel.listitem.Tabs
import org.michaelbel.listitem.sample08_NavigationSuiteScaffold_PrimaryActionContent.main.about.AboutScreen
import org.michaelbel.listitem.sample08_NavigationSuiteScaffold_PrimaryActionContent.main.home.HomeScreen
import org.michaelbel.listitem.sample08_NavigationSuiteScaffold_PrimaryActionContent.main.settings.SettingsScreen

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }
    val primaryActionAlignment by AppSettings.primaryActionAlignmentFlow.collectAsStateWithLifecycle()

    val navigationSuiteType = NavigationSuiteScaffoldDefaults.navigationSuiteType(currentWindowAdaptiveInfo())
    val isNavigationBar = navigationSuiteType == NavigationSuiteType.ShortNavigationBarCompact
    val isNavigationRail = navigationSuiteType == NavigationSuiteType.WideNavigationRailCollapsed

    NavigationSuiteScaffold(
        navigationItems = {
            when {
                isNavigationRail -> {
                    NavigationRail(
                        header = {
                            FloatingActionButton(
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = null
                                )
                            }
                        }
                    ) {
                        NavigationRailItem(
                            selected = selectedTab == Tabs.Home,
                            onClick = { selectedTab = Tabs.Home },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Home,
                                    contentDescription = null
                                )
                            }
                        )

                        NavigationRailItem(
                            selected = selectedTab == Tabs.Settings,
                            onClick = { selectedTab = Tabs.Settings },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Settings,
                                    contentDescription = null
                                )
                            }
                        )

                        NavigationRailItem(
                            selected = selectedTab == Tabs.About,
                            onClick = { selectedTab = Tabs.About },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
                else -> {
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
                }
            }
        },
        navigationSuiteType = navigationSuiteType,
        primaryActionContent = {
            if (isNavigationBar) {
                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null
                    )
                }
            }
        },
        primaryActionContentHorizontalAlignment = primaryActionAlignment
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
                    isNavigationRail = isNavigationRail,
                    isNavigationBar = isNavigationBar
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
