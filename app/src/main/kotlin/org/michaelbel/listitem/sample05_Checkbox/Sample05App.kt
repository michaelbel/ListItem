@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample05_Checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun Sample05App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Checkbox") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Базовый Checkbox (trailing)") }
            item {
                var checked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Принять условия") },
                    trailingContent = {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }
            item {
                var checked by remember { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Подписка на рассылку") },
                    trailingContent = {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Checkbox с вспомогательным текстом") }
            item {
                var checked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Push-уведомления") },
                    supportingContent = { Text("Получать сообщения на этом устройстве") },
                    trailingContent = {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }
            item {
                var checked by remember { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Email-уведомления") },
                    supportingContent = { Text("Еженедельные сводки и важные события") },
                    trailingContent = {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Checkbox в начале строки (leading)") }
            item {
                var checked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Задача выполнена") },
                    supportingContent = { Text("Чекбокс слева — альтернативное расположение") },
                    leadingContent = {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Отключённый Checkbox") }
            item {
                ListItem(
                    headlineContent = { Text("Системный параметр (включено)") },
                    supportingContent = { Text("Нельзя изменить в этом режиме") },
                    trailingContent = {
                        Checkbox(
                            checked = true,
                            onCheckedChange = null,
                            enabled = false
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Системный параметр (выключено)") },
                    supportingContent = { Text("Недоступно без прав администратора") },
                    trailingContent = {
                        Checkbox(
                            checked = false,
                            onCheckedChange = null,
                            enabled = false
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Выбрать всё — неопределённое состояние (TriStateCheckbox)") }
            item {
                var item1 by rememberSaveable { mutableStateOf(true) }
                var item2 by rememberSaveable { mutableStateOf(false) }
                var item3 by rememberSaveable { mutableStateOf(true) }

                val selectAllState by remember {
                    derivedStateOf {
                        when {
                            item1 && item2 && item3 -> ToggleableState.On
                            !item1 && !item2 && !item3 -> ToggleableState.Off
                            else -> ToggleableState.Indeterminate
                        }
                    }
                }

                ListItem(
                    headlineContent = { Text("Выбрать всё") },
                    supportingContent = {
                        Text(
                            when (selectAllState) {
                                ToggleableState.On -> "Все пункты выбраны"
                                ToggleableState.Off -> "Ни один не выбран"
                                ToggleableState.Indeterminate -> "Выбрано частично"
                            }
                        )
                    },
                    trailingContent = {
                        TriStateCheckbox(
                            state = selectAllState,
                            onClick = {
                                val newValue = selectAllState != ToggleableState.On
                                item1 = newValue
                                item2 = newValue
                                item3 = newValue
                            }
                        )
                    },
                    modifier = Modifier.clickable {
                        val newValue = selectAllState != ToggleableState.On
                        item1 = newValue
                        item2 = newValue
                        item3 = newValue
                    }
                )
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    trailingContent = {
                        Checkbox(checked = item1, onCheckedChange = { item1 = it })
                    },
                    modifier = Modifier.clickable { item1 = !item1 }
                )
                ListItem(
                    headlineContent = { Text("Email-рассылка") },
                    trailingContent = {
                        Checkbox(checked = item2, onCheckedChange = { item2 = it })
                    },
                    modifier = Modifier.clickable { item2 = !item2 }
                )
                ListItem(
                    headlineContent = { Text("Аналитика") },
                    trailingContent = {
                        Checkbox(checked = item3, onCheckedChange = { item3 = it })
                    },
                    modifier = Modifier.clickable { item3 = !item3 }
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
