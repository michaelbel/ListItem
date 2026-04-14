@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample06_RadioButton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
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

@Composable
fun Sample06App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("RadioButton") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Базовая группа RadioButton (trailing)") }
            item {
                val options = listOf("Вариант А", "Вариант Б", "Вариант В")
                var selected by rememberSaveable { mutableStateOf(options[0]) }
                options.forEach { option ->
                    ListItem(
                        headlineContent = { Text(option) },
                        trailingContent = {
                            RadioButton(
                                selected = selected == option,
                                onClick = { selected = option }
                            )
                        },
                        modifier = Modifier.clickable { selected = option }
                    )
                }
            }

            item { HorizontalDivider() }

            item { SectionLabel("RadioButton с вспомогательным текстом") }
            item {
                data class SortOption(val label: String, val description: String)
                val sortOptions = listOf(
                    SortOption("По дате", "Сначала новые"),
                    SortOption("По названию", "В алфавитном порядке"),
                    SortOption("По размеру", "От большего к меньшему"),
                    SortOption("По типу", "Группировка по формату")
                )
                var selected by rememberSaveable { mutableStateOf(sortOptions[0].label) }
                sortOptions.forEach { option ->
                    ListItem(
                        headlineContent = { Text(option.label) },
                        supportingContent = { Text(option.description) },
                        trailingContent = {
                            RadioButton(
                                selected = selected == option.label,
                                onClick = { selected = option.label }
                            )
                        },
                        modifier = Modifier.clickable { selected = option.label }
                    )
                }
            }

            item { HorizontalDivider() }

            item { SectionLabel("RadioButton с ведущей иконкой") }
            item {
                var selectedTheme by rememberSaveable { mutableStateOf("light") }
                ListItem(
                    headlineContent = { Text("Светлая тема") },
                    supportingContent = { Text("Всегда использовать светлый интерфейс") },
                    leadingContent = {
                        Icon(Icons.Outlined.LightMode, contentDescription = null)
                    },
                    trailingContent = {
                        RadioButton(
                            selected = selectedTheme == "light",
                            onClick = { selectedTheme = "light" }
                        )
                    },
                    modifier = Modifier.clickable { selectedTheme = "light" }
                )
                ListItem(
                    headlineContent = { Text("Тёмная тема") },
                    supportingContent = { Text("Всегда использовать тёмный интерфейс") },
                    leadingContent = {
                        Icon(Icons.Outlined.DarkMode, contentDescription = null)
                    },
                    trailingContent = {
                        RadioButton(
                            selected = selectedTheme == "dark",
                            onClick = { selectedTheme = "dark" }
                        )
                    },
                    modifier = Modifier.clickable { selectedTheme = "dark" }
                )
                ListItem(
                    headlineContent = { Text("Системная тема") },
                    supportingContent = { Text("Следовать настройкам устройства") },
                    leadingContent = {
                        Icon(Icons.Outlined.Settings, contentDescription = null)
                    },
                    trailingContent = {
                        RadioButton(
                            selected = selectedTheme == "system",
                            onClick = { selectedTheme = "system" }
                        )
                    },
                    modifier = Modifier.clickable { selectedTheme = "system" }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Отключённый RadioButton") }
            item {
                ListItem(
                    headlineContent = { Text("Только для администратора") },
                    supportingContent = { Text("Недоступно в текущем режиме") },
                    trailingContent = {
                        RadioButton(
                            selected = false,
                            onClick = null,
                            enabled = false
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Заблокированная опция (выбрана)") },
                    supportingContent = { Text("Изменить нельзя") },
                    trailingContent = {
                        RadioButton(
                            selected = true,
                            onClick = null,
                            enabled = false
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("RadioButton в начале строки (leading)") }
            item {
                val options = listOf("Мобильные данные", "Wi-Fi", "Авто")
                var selected by rememberSaveable { mutableStateOf(options[2]) }
                options.forEach { option ->
                    ListItem(
                        headlineContent = { Text(option) },
                        leadingContent = {
                            RadioButton(
                                selected = selected == option,
                                onClick = { selected = option }
                            )
                        },
                        modifier = Modifier.clickable { selected = option }
                    )
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
