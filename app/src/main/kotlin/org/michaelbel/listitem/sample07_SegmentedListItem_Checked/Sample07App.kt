package org.michaelbel.listitem.sample07_SegmentedListItem_Checked

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Fingerprint
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedListItem
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
fun Sample07App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    var wifiChecked by rememberSaveable { mutableStateOf(true) }
    var bluetoothChecked by rememberSaveable { mutableStateOf(false) }
    var locationChecked by rememberSaveable { mutableStateOf(true) }

    var notificationsChecked by rememberSaveable { mutableStateOf(true) }
    var darkModeChecked by rememberSaveable { mutableStateOf(false) }
    var fingerprintChecked by rememberSaveable { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("SegmentedListItem Checked") },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding + PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item { SectionLabel("Switch") }
            item {
                SegmentedListItem(
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
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Wi-Fi") }
            }
            item {
                SegmentedListItem(
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
                    shapes = ListItemDefaults.segmentedShapes(index = 1, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Bluetooth") }
            }
            item {
                SegmentedListItem(
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
                    shapes = ListItemDefaults.segmentedShapes(index = 2, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Геолокация") }
            }

            item { SectionLabel("Checkbox") }
            item {
                SegmentedListItem(
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
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Уведомления") }
            }
            item {
                SegmentedListItem(
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
                    shapes = ListItemDefaults.segmentedShapes(index = 1, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Тёмная тема") }
            }
            item {
                SegmentedListItem(
                    checked = fingerprintChecked,
                    onCheckedChange = { fingerprintChecked = it },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Fingerprint,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Checkbox(
                            checked = fingerprintChecked,
                            onCheckedChange = { fingerprintChecked = it }
                        )
                    },
                    supportingContent = { Text("Вход по отпечатку пальца") },
                    shapes = ListItemDefaults.segmentedShapes(index = 2, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Биометрия") }
            }
        }
    }
}
