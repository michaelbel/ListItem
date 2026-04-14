@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.listitem.sample02_NavigationSuiteScaffold_NavigationBar.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.michaelbel.listitem.Tabs
import org.michaelbel.listitem.sample02_NavigationSuiteScaffold_NavigationBar.main.about.AboutScreen
import org.michaelbel.listitem.sample02_NavigationSuiteScaffold_NavigationBar.main.home.HomeScreen
import org.michaelbel.listitem.sample02_NavigationSuiteScaffold_NavigationBar.main.settings.SettingsScreen

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }

    NavigationSuiteScaffold(
        navigationItems = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                NavigationBarItem(
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

                NavigationBarItem(
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

                NavigationBarItem(
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
        },
        navigationSuiteType = NavigationSuiteType.ShortNavigationBarCompact
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
