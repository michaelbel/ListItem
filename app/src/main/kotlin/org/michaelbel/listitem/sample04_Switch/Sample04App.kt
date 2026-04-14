@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample04_Switch

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
fun Sample04App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Switch") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Базовый Switch") }
            item {
                var checked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Тёмная тема") },
                    trailingContent = {
                        Switch(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Switch с иконкой в ползунке") }
            item {
                var checked by remember { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Галочка при включении") },
                    supportingContent = { Text("thumbContent отображает иконку когда checked = true") },
                    trailingContent = {
                        Switch(
                            checked = checked,
                            onCheckedChange = { checked = it },
                            thumbContent = if (checked) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Check,
                                        contentDescription = null,
                                        modifier = Modifier.size(SwitchDefaults.IconSize)
                                    )
                                }
                            } else null
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Switch с ведущей иконкой и вспомогательным текстом") }
            item {
                var wifi by remember { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Wi-Fi") },
                    supportingContent = { Text("Подключён к «Home_Network»") },
                    leadingContent = {
                        Icon(Icons.Outlined.Wifi, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(checked = wifi, onCheckedChange = { wifi = it })
                    }
                )
            }
            item {
                var bluetooth by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Bluetooth") },
                    supportingContent = { Text("Нет подключённых устройств") },
                    leadingContent = {
                        Icon(Icons.Outlined.Bluetooth, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(checked = bluetooth, onCheckedChange = { bluetooth = it })
                    }
                )
            }
            item {
                var location by remember { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Геолокация") },
                    supportingContent = { Text("Режим высокой точности") },
                    leadingContent = {
                        Icon(Icons.Outlined.LocationOn, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(checked = location, onCheckedChange = { location = it })
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Отключённый Switch (enabled = false)") }
            item {
                ListItem(
                    headlineContent = { Text("Уведомления (включено, недоступно)") },
                    supportingContent = { Text("Управляется системными настройками") },
                    leadingContent = {
                        Icon(Icons.Outlined.Notifications, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(
                            checked = true,
                            onCheckedChange = null,
                            enabled = false
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Тёмная тема (выключено, недоступно)") },
                    supportingContent = { Text("Требуется подписка") },
                    leadingContent = {
                        Icon(Icons.Outlined.DarkMode, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(
                            checked = false,
                            onCheckedChange = null,
                            enabled = false
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Группа настроек — реальный сценарий") }
            item {
                var notifications by rememberSaveable { mutableStateOf(true) }
                var darkMode by rememberSaveable { mutableStateOf(false) }
                var language by rememberSaveable { mutableStateOf(true) }

                ListItem(
                    headlineContent = { Text("Уведомления") },
                    overlineContent = { Text("ОСНОВНЫЕ") },
                    leadingContent = {
                        Icon(Icons.Outlined.Notifications, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(checked = notifications, onCheckedChange = { notifications = it })
                    }
                )
                ListItem(
                    headlineContent = { Text("Тёмная тема") },
                    leadingContent = {
                        Icon(Icons.Outlined.DarkMode, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(checked = darkMode, onCheckedChange = { darkMode = it })
                    }
                )
                ListItem(
                    headlineContent = { Text("Синхронизация языка") },
                    leadingContent = {
                        Icon(Icons.Outlined.Language, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(checked = language, onCheckedChange = { language = it })
                    }
                )
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 4.dp)
    )
}
