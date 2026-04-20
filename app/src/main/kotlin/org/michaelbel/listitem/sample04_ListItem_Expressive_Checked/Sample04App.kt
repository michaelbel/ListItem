@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem.sample04_ListItem_Expressive_Checked

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import org.michaelbel.listitem.SectionLabel

@Composable
fun Sample04App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    var wifiChecked by rememberSaveable { mutableStateOf(true) }
    var bluetoothChecked by rememberSaveable { mutableStateOf(true) }
    var locationChecked by rememberSaveable { mutableStateOf(false) }

    var notificationsChecked by rememberSaveable { mutableStateOf(true) }
    var darkModeChecked by rememberSaveable { mutableStateOf(false) }
    var languageChecked by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("ListItem Expressive Checked") },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = innerPadding.calculateTopPadding(),
                end = 16.dp,
                bottom = innerPadding.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            item { SectionLabel("Switch") }
            item {
                ListItem(
                    checked = wifiChecked,
                    onCheckedChange = { wifiChecked = it },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Wifi,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = wifiChecked,
                            onCheckedChange = { wifiChecked = it }
                        )
                    },
                    supportingContent = { Text(if (wifiChecked) "Подключено" else "Отключено") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Wi-Fi") }
            }
            item {
                ListItem(
                    checked = bluetoothChecked,
                    onCheckedChange = { bluetoothChecked = it },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Bluetooth,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = bluetoothChecked,
                            onCheckedChange = { bluetoothChecked = it }
                        )
                    },
                    supportingContent = { Text(if (bluetoothChecked) "Включён" else "Выключен") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Bluetooth") }
            }
            item {
                ListItem(
                    checked = locationChecked,
                    onCheckedChange = { locationChecked = it },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = locationChecked,
                            onCheckedChange = { locationChecked = it }
                        )
                    },
                    supportingContent = { Text(if (locationChecked) "Разрешена" else "Запрещена") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Геолокация") }
            }
            item { SectionLabel("Checkbox") }
            item {
                ListItem(
                    checked = notificationsChecked,
                    onCheckedChange = { notificationsChecked = it },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Checkbox(
                            checked = notificationsChecked,
                            onCheckedChange = { notificationsChecked = it }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Уведомления") }
            }
            item {
                ListItem(
                    checked = darkModeChecked,
                    onCheckedChange = { darkModeChecked = it },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.DarkMode,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Checkbox(
                            checked = darkModeChecked,
                            onCheckedChange = { darkModeChecked = it }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Темная тема") }
            }
            item {
                ListItem(
                    checked = languageChecked,
                    onCheckedChange = { languageChecked = it },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Language,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Checkbox(
                            checked = languageChecked,
                            onCheckedChange = { languageChecked = it }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Автоопределение языка") }
            }
        }
    }
}
