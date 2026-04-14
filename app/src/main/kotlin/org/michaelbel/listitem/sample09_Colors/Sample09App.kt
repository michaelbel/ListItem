@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample09_Colors

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
fun Sample09App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Цвета") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Цвета по умолчанию") }
            item {
                ListItem(
                    headlineContent = { Text("Стандартный ListItem") },
                    supportingContent = { Text("ListItemDefaults.colors() без изменений") },
                    leadingContent = {
                        Icon(Icons.Outlined.Settings, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors()
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Кастомный containerColor") }
            item {
                ListItem(
                    headlineContent = { Text("Primary Container") },
                    supportingContent = { Text("containerColor = primaryContainer") },
                    leadingContent = {
                        Icon(Icons.Outlined.Star, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Secondary Container") },
                    supportingContent = { Text("containerColor = secondaryContainer") },
                    leadingContent = {
                        Icon(Icons.Outlined.Email, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Tertiary Container") },
                    supportingContent = { Text("containerColor = tertiaryContainer") },
                    leadingContent = {
                        Icon(Icons.Outlined.Notifications, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Error Container") },
                    supportingContent = { Text("containerColor = errorContainer") },
                    leadingContent = {
                        Icon(Icons.Outlined.Warning, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Кастомный цвет текста") }
            item {
                ListItem(
                    headlineContent = { Text("Цветной заголовок") },
                    supportingContent = { Text("headlineColor = primary") },
                    colors = ListItemDefaults.colors(
                        headlineColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Цветной вспомогательный текст") },
                    supportingContent = { Text("supportingColor = tertiary") },
                    colors = ListItemDefaults.colors(
                        supportingColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Overline другого цвета") },
                    overlineContent = { Text("OVERLINE") },
                    supportingContent = { Text("overlineColor = secondary") },
                    colors = ListItemDefaults.colors(
                        overlineColor = MaterialTheme.colorScheme.secondary
                    )
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Кастомный цвет иконок") }
            item {
                ListItem(
                    headlineContent = { Text("Иконки основного цвета") },
                    supportingContent = { Text("leadingIconColor = trailingIconColor = primary") },
                    leadingContent = {
                        Icon(Icons.Outlined.Person, contentDescription = null)
                    },
                    trailingContent = {
                        Icon(Icons.Outlined.Settings, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        leadingIconColor = MaterialTheme.colorScheme.primary,
                        trailingIconColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Предупреждение") },
                    supportingContent = { Text("Иконки красного цвета") },
                    leadingContent = {
                        Icon(Icons.Outlined.Warning, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        leadingIconColor = MaterialTheme.colorScheme.error
                    )
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Тональное и теневое возвышение") }
            item {
                ListItem(
                    headlineContent = { Text("tonalElevation = 0.dp") },
                    supportingContent = { Text("Без тонального возвышения (по умолчанию)") },
                    tonalElevation = 0.dp
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("tonalElevation = 4.dp") },
                    supportingContent = { Text("Поверхность чуть светлее") },
                    tonalElevation = 4.dp
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("tonalElevation = 8.dp") },
                    supportingContent = { Text("Ещё светлее") },
                    tonalElevation = 8.dp
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("shadowElevation = 4.dp") },
                    supportingContent = { Text("Тень под элементом") },
                    shadowElevation = 4.dp
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("tonalElevation + shadowElevation") },
                    supportingContent = { Text("Оба параметра одновременно: 4.dp + 4.dp") },
                    tonalElevation = 4.dp,
                    shadowElevation = 4.dp
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Полная кастомизация всех цветов") }
            item {
                ListItem(
                    headlineContent = { Text("Полностью кастомный ListItem") },
                    overlineContent = { Text("CUSTOM COLORS") },
                    supportingContent = { Text("Все цвета переопределены") },
                    leadingContent = {
                        Icon(Icons.Outlined.Star, contentDescription = null)
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = Color(0xFFE8F5E9),
                        headlineColor = Color(0xFF1B5E20),
                        overlineColor = Color(0xFF2E7D32),
                        supportingColor = Color(0xFF388E3C),
                        leadingIconColor = Color(0xFF1B5E20)
                    )
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
