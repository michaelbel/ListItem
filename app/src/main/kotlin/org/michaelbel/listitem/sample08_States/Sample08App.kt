@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample08_States

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
fun Sample08App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Состояния") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Статичный (не кликабельный)") }
            item {
                ListItem(
                    headlineContent = { Text("Информационный пункт") },
                    supportingContent = { Text("Нет взаимодействия, только отображение") },
                    leadingContent = { Icon(Icons.Outlined.Home, contentDescription = null) }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Кликабельный (с ripple-эффектом)") }
            item {
                ListItem(
                    headlineContent = { Text("Нажмите на меня") },
                    supportingContent = { Text("onClick + Modifier.clickable — даёт ripple") },
                    leadingContent = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { /* navigate */ }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Перейти к профилю") },
                    leadingContent = { Icon(Icons.Outlined.Person, contentDescription = null) },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { /* navigate */ }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Выбранное состояние (selected)") }
            item {
                val items = listOf("Дом", "Работа", "Кафе")
                var selected by remember { mutableStateOf(items[0]) }
                items.forEach { item ->
                    val isSelected = selected == item
                    ListItem(
                        headlineContent = { Text(item) },
                        supportingContent = {
                            Text(if (isSelected) "Выбрано" else "Нажмите для выбора")
                        },
                        leadingContent = { Icon(Icons.Outlined.Home, contentDescription = null) },
                        colors = if (isSelected) {
                            ListItemDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                headlineColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                supportingColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                leadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        } else {
                            ListItemDefaults.colors()
                        },
                        modifier = Modifier.clickable { selected = item }
                    )
                }
            }

            item { HorizontalDivider() }

            item { SectionLabel("Переключаемое избранное") }
            item {
                val items = listOf("Кофе со льдом", "Капучино", "Эспрессо")
                val favorites = remember { mutableStateOf(setOf("Капучино")) }
                items.forEach { item ->
                    val isFavorite = item in favorites.value
                    ListItem(
                        headlineContent = { Text(item) },
                        supportingContent = { Text(if (isFavorite) "В избранном" else "Добавить в избранное") },
                        trailingContent = {
                            IconButton(onClick = {
                                favorites.value = if (isFavorite) {
                                    favorites.value - item
                                } else {
                                    favorites.value + item
                                }
                            }) {
                                Icon(
                                    imageVector = if (isFavorite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                                    contentDescription = null,
                                    tint = if (isFavorite) MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        },
                        modifier = Modifier.clickable { /* open detail */ }
                    )
                }
            }

            item { HorizontalDivider() }

            item { SectionLabel("Отключённый (disabled)") }
            item {
                ListItem(
                    headlineContent = { Text("Недоступный пункт") },
                    supportingContent = { Text("alpha = 0.38f, clickable(enabled = false)") },
                    leadingContent = { Icon(Icons.Outlined.Email, contentDescription = null) },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .alpha(0.38f)
                        .clickable(enabled = false) {}
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Удалить аккаунт") },
                    supportingContent = { Text("Требуется подтверждение email") },
                    leadingContent = {
                        Icon(
                            Icons.Outlined.Delete,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    },
                    modifier = Modifier
                        .alpha(0.38f)
                        .clickable(enabled = false) {}
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Комбо: список с действиями Edit / Delete") }
            item {
                val notes = remember {
                    mutableStateOf(
                        listOf("Купить продукты", "Позвонить врачу", "Написать отчёт")
                    )
                }
                notes.value.forEach { note ->
                    ListItem(
                        headlineContent = { Text(note) },
                        trailingContent = {
                            androidx.compose.foundation.layout.Row {
                                IconButton(onClick = { /* edit */ }) {
                                    Icon(Icons.Outlined.Edit, contentDescription = "Редактировать")
                                }
                                IconButton(onClick = {
                                    notes.value = notes.value - note
                                }) {
                                    Icon(
                                        Icons.Outlined.Delete,
                                        contentDescription = "Удалить",
                                        tint = MaterialTheme.colorScheme.error
                                    )
                                }
                            }
                        },
                        modifier = Modifier.clickable { /* open */ }
                    )
                    HorizontalDivider()
                }
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
