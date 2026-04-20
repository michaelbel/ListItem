@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample01_ListItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import org.michaelbel.listitem.SectionLabel

@Composable
fun Sample01App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("ListItem") },
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
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            item { SectionLabel("headlineContent") }
            item {
                ListItem(
                    headlineContent = { Text("Главный текст") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("headlineContent + supportingContent") }
            item {
                ListItem(
                    headlineContent = { Text("Главный текст") },
                    supportingContent = { Text("Вспомогательный текст") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("headlineContent + overlineContent + supportingContent") }
            item {
                ListItem(
                    headlineContent = { Text("Главный текст") },
                    overlineContent = { Text("КАТЕГОРИЯ") },
                    supportingContent = { Text("Вспомогательный текст") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("leadingContent") }
            item {
                ListItem(
                    headlineContent = { Text("Icon") },
                    supportingContent = { Text("Size 24.dp") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Avatar") },
                    supportingContent = { Text("Size 40.dp") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "А",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Thumbnail") },
                    supportingContent = { Text("Size 56.dp") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.tertiaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.MusicNote,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("trailingContent") }
            item {
                ListItem(
                    headlineContent = { Text("Иконка-стрелка") },
                    supportingContent = { Text("Переход на следующий экран") },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                var checked by remember { mutableStateOf(true) }

                ListItem(
                    headlineContent = { Text("Switch") },
                    supportingContent = { Text("Переключатель вкл/выкл") },
                    trailingContent = {
                        Switch(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                var checked by remember { mutableStateOf(true) }

                ListItem(
                    headlineContent = { Text("Checkbox") },
                    supportingContent = { Text("Флажок выбора") },
                    trailingContent = {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                var selected by remember { mutableStateOf(true) }

                ListItem(
                    headlineContent = { Text("RadioButton") },
                    supportingContent = { Text("Одиночный выбор") },
                    trailingContent = {
                        RadioButton(
                            selected = selected,
                            onClick = { selected = !selected }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("colors") }
            item {
                ListItem(
                    headlineContent = { Text("containerColor") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("headlineColor") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        headlineColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("leadingIconColor") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        leadingIconColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("overlineColor") },
                    overlineContent = { Text("overlineColor") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        overlineColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("supportingColor") },
                    supportingContent = { Text("supportingColor") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        supportingColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("trailingIconColor") },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        trailingIconColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
            item { SectionLabel("tonalElevation") }
            item {
                ListItem(
                    headlineContent = { Text("16.dp") },
                    tonalElevation = 16.dp
                )
            }
            item { SectionLabel("shadowElevation") }
            item {
                ListItem(
                    headlineContent = { Text("16.dp") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    shadowElevation = 16.dp
                )
            }
        }
    }
}
