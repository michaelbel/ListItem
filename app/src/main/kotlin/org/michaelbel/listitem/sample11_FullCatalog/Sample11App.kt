@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample11_FullCatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Badge
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun Sample11App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Полный каталог") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // ── 1. Только текст ─────────────────────────────────────────
            item { CatalogHeader("1. Текстовые варианты") }
            item { ListItem(headlineContent = { Text("Только заголовок") }) }
            item {
                ListItem(
                    headlineContent = { Text("Заголовок + вспомогательный") },
                    supportingContent = { Text("Supporting Content") }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Надстрочный + заголовок") },
                    overlineContent = { Text("OVERLINE") }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Три строки текста") },
                    overlineContent = { Text("OVERLINE") },
                    supportingContent = { Text("Supporting Content") }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Длинный вспомогательный текст") },
                    supportingContent = {
                        Text(
                            "Пример трёхстрочного ListItem, " +
                                "где вспомогательный текст переносится на несколько строк"
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            // ── 2. Ведущий контент ───────────────────────────────────────
            item { CatalogHeader("2. Ведущий контент") }
            item {
                ListItem(
                    headlineContent = { Text("Стандартная иконка") },
                    leadingContent = { Icon(Icons.Outlined.Home, contentDescription = null) }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Большая иконка 40 dp") },
                    leadingContent = {
                        Icon(
                            Icons.Outlined.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Буквенный аватар") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "А",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Миниатюра 56 dp") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Outlined.MusicNote,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                )
            }

            item { HorizontalDivider() }

            // ── 3. Концевой контент ──────────────────────────────────────
            item { CatalogHeader("3. Концевой контент") }
            item {
                ListItem(
                    headlineContent = { Text("Стрелка навигации") },
                    leadingContent = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Текстовые метаданные") },
                    supportingContent = { Text("Последнее сообщение") },
                    trailingContent = {
                        Text(
                            "14:23",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Кнопка с иконкой") },
                    trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.MoreVert, contentDescription = null)
                        }
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Бейдж с числом") },
                    leadingContent = { Icon(Icons.Outlined.Email, contentDescription = null) },
                    trailingContent = { Badge { Text("5") } }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Иконка действия") },
                    trailingContent = {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            // ── 4. Switch ────────────────────────────────────────────────
            item { CatalogHeader("4. Switch") }
            item {
                var checked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Базовый Switch") },
                    leadingContent = { Icon(Icons.Outlined.Wifi, contentDescription = null) },
                    trailingContent = {
                        Switch(checked = checked, onCheckedChange = { checked = it })
                    }
                )
            }
            item {
                var checked by remember { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Switch с иконкой в ползунке") },
                    leadingContent = { Icon(Icons.Outlined.DarkMode, contentDescription = null) },
                    trailingContent = {
                        Switch(
                            checked = checked,
                            onCheckedChange = { checked = it },
                            thumbContent = if (checked) {
                                {
                                    Icon(
                                        Icons.Filled.Check,
                                        contentDescription = null,
                                        modifier = Modifier.size(SwitchDefaults.IconSize)
                                    )
                                }
                            } else null
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Switch (disabled)") },
                    leadingContent = { Icon(Icons.Outlined.Notifications, contentDescription = null) },
                    trailingContent = {
                        Switch(checked = true, onCheckedChange = null, enabled = false)
                    },
                    modifier = Modifier.alpha(0.38f)
                )
            }

            item { HorizontalDivider() }

            // ── 5. Checkbox ──────────────────────────────────────────────
            item { CatalogHeader("5. Checkbox") }
            item {
                var checked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Checkbox trailing") },
                    trailingContent = {
                        Checkbox(checked = checked, onCheckedChange = { checked = it })
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }
            item {
                var checked by remember { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Checkbox с вспомогательным текстом") },
                    supportingContent = { Text("Включить Email-уведомления") },
                    trailingContent = {
                        Checkbox(checked = checked, onCheckedChange = { checked = it })
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }
            item {
                var checked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Checkbox leading") },
                    leadingContent = {
                        Checkbox(checked = checked, onCheckedChange = { checked = it })
                    },
                    modifier = Modifier.clickable { checked = !checked }
                )
            }

            item { HorizontalDivider() }

            // ── 6. RadioButton ───────────────────────────────────────────
            item { CatalogHeader("6. RadioButton") }
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

            // ── 7. Разделители ───────────────────────────────────────────
            item { CatalogHeader("7. Разделители и индикаторы") }
            item {
                ListItem(headlineContent = { Text("Пункт с full-width divider") })
            }
            item { HorizontalDivider() }
            item {
                ListItem(
                    headlineContent = { Text("Пункт с inset divider") },
                    leadingContent = { Icon(Icons.Outlined.Person, contentDescription = null) }
                )
            }
            item { HorizontalDivider(modifier = Modifier.padding(start = 72.dp)) }
            item {
                ListItem(
                    headlineContent = { Text("Следующий пункт") },
                    leadingContent = { Icon(Icons.Outlined.Security, contentDescription = null) }
                )
            }
            item {
                val indicatorColor = MaterialTheme.colorScheme.error
                ListItem(
                    headlineContent = { Text("Вертикальная черта (drawWithContent)") },
                    supportingContent = { Text("Индикатор слева через drawWithContent") },
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        drawRect(
                            color = indicatorColor,
                            topLeft = Offset.Zero,
                            size = Size(4.dp.toPx(), size.height)
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Цветной маркер в leading") },
                    supportingContent = { Text("Box(4.dp × 40.dp) как ведущий контент") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .width(4.dp)
                                .height(40.dp)
                                .background(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.shapes.small
                                )
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            // ── 8. Состояния ─────────────────────────────────────────────
            item { CatalogHeader("8. Состояния") }
            item {
                ListItem(
                    headlineContent = { Text("Кликабельный") },
                    supportingContent = { Text("Modifier.clickable {}") },
                    leadingContent = { Icon(Icons.Outlined.Search, contentDescription = null) },
                    modifier = Modifier.clickable { }
                )
            }
            item {
                var isSelected by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text(if (isSelected) "Выбрано!" else "Нажмите для выбора") },
                    colors = if (isSelected) ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ) else ListItemDefaults.colors(),
                    modifier = Modifier.clickable { isSelected = !isSelected }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Отключённый (disabled)") },
                    supportingContent = { Text("alpha = 0.38f, clickable(enabled = false)") },
                    leadingContent = { Icon(Icons.Outlined.Info, contentDescription = null) },
                    modifier = Modifier
                        .alpha(0.38f)
                        .clickable(enabled = false) {}
                )
            }

            item { HorizontalDivider() }

            // ── 9. Цвета ─────────────────────────────────────────────────
            item { CatalogHeader("9. Цвета") }
            item {
                ListItem(
                    headlineContent = { Text("Primary Container") },
                    leadingContent = { Icon(Icons.Outlined.Star, contentDescription = null) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Secondary Container") },
                    leadingContent = { Icon(Icons.Outlined.Email, contentDescription = null) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            }
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
                    headlineContent = { Text("tonalElevation = 8.dp") },
                    supportingContent = { Text("Поверхность светлее фона") },
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

            item { HorizontalDivider() }

            // ── 10. Комбинированный реальный пример ──────────────────────
            item { CatalogHeader("10. Реальный пример — настройки") }
            item {
                Text(
                    text = "ПОДКЛЮЧЕНИЯ",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 4.dp)
                )
                var wifi by rememberSaveable { mutableStateOf(true) }
                var notifications by rememberSaveable { mutableStateOf(true) }
                ListItem(
                    headlineContent = { Text("Wi-Fi") },
                    supportingContent = { Text(if (wifi) "Home_Network" else "Выключено") },
                    leadingContent = {
                        Icon(
                            Icons.Outlined.Wifi,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    },
                    trailingContent = { Switch(checked = wifi, onCheckedChange = { wifi = it }) }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 72.dp))
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    overlineContent = { Text("СИСТЕМНЫЕ") },
                    supportingContent = {
                        Text(if (notifications) "Включены для всех приложений" else "Выключены")
                    },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Outlined.Notifications,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    },
                    trailingContent = {
                        Switch(
                            checked = notifications,
                            onCheckedChange = { notifications = it }
                        )
                    }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 72.dp))
                ListItem(
                    headlineContent = {
                        Text("Папки", fontWeight = FontWeight.Medium)
                    },
                    supportingContent = { Text("12 элементов · 4.2 ГБ") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.tertiaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Outlined.Folder,
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                                tint = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    },
                    trailingContent = {
                        androidx.compose.foundation.layout.Row {
                            IconButton(onClick = {}) {
                                Icon(Icons.Outlined.Share, contentDescription = "Поделиться")
                            }
                            IconButton(onClick = {}) {
                                Icon(Icons.Outlined.Download, contentDescription = "Скачать")
                            }
                        }
                    },
                    modifier = Modifier.clickable { },
                    tonalElevation = 2.dp
                )
                HorizontalDivider(modifier = Modifier.padding(start = 72.dp))
                val primaryColor = MaterialTheme.colorScheme.error
                ListItem(
                    headlineContent = { Text("Критическое обновление") },
                    supportingContent = { Text("Требуется немедленное действие") },
                    leadingContent = {
                        Icon(Icons.Outlined.Security, contentDescription = null)
                    },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .clickable { }
                        .drawWithContent {
                            drawContent()
                            drawRect(
                                color = primaryColor,
                                topLeft = Offset.Zero,
                                size = Size(4.dp.toPx(), size.height)
                            )
                        },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                )
            }
        }
    }
}

@Composable
private fun CatalogHeader(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
    )
}
