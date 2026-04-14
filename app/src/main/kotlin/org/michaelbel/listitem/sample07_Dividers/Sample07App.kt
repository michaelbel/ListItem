@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample07_Dividers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
fun Sample07App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Разделители и индикаторы") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("HorizontalDivider на всю ширину") }
            item {
                ListItem(
                    headlineContent = { Text("Пункт 1") },
                    supportingContent = { Text("Разделитель на полную ширину") }
                )
            }
            item { HorizontalDivider() }
            item {
                ListItem(
                    headlineContent = { Text("Пункт 2") },
                    supportingContent = { Text("Разделитель на полную ширину") }
                )
            }
            item { HorizontalDivider() }
            item {
                ListItem(
                    headlineContent = { Text("Пункт 3") },
                    supportingContent = { Text("Разделитель на полную ширину") }
                )
            }

            item { HorizontalDivider(modifier = Modifier.padding(top = 8.dp)) }

            item { SectionLabel("Вложенный HorizontalDivider (с отступом под иконку)") }
            item {
                ListItem(
                    headlineContent = { Text("Входящие") },
                    supportingContent = { Text("3 непрочитанных") },
                    leadingContent = {
                        Icon(Icons.Outlined.Email, contentDescription = null)
                    }
                )
            }
            // Отступ 72dp = 16 (padding) + 24 (icon) + 32 (icon trailing padding внутри ListItem)
            item { HorizontalDivider(modifier = Modifier.padding(start = 72.dp)) }
            item {
                ListItem(
                    headlineContent = { Text("Профиль") },
                    supportingContent = { Text("Алексей Смирнов") },
                    leadingContent = {
                        Icon(Icons.Outlined.Person, contentDescription = null)
                    }
                )
            }
            item { HorizontalDivider(modifier = Modifier.padding(start = 72.dp)) }
            item {
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    supportingContent = { Text("Включены для всех приложений") },
                    leadingContent = {
                        Icon(Icons.Outlined.Notifications, contentDescription = null)
                    }
                )
            }

            item { HorizontalDivider(modifier = Modifier.padding(top = 8.dp)) }

            item { SectionLabel("Заголовок секции (subheader) между разделителями") }
            item {
                Text(
                    text = "АККАУНТ",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 12.dp, bottom = 4.dp)
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Профиль") },
                    leadingContent = {
                        Icon(Icons.Outlined.Person, contentDescription = null)
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Настройки") },
                    leadingContent = {
                        Icon(Icons.Outlined.Settings, contentDescription = null)
                    }
                )
            }
            item {
                Text(
                    text = "ПРИЛОЖЕНИЕ",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 12.dp, bottom = 4.dp)
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    leadingContent = {
                        Icon(Icons.Outlined.Notifications, contentDescription = null)
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Главная") },
                    leadingContent = {
                        Icon(Icons.Outlined.Home, contentDescription = null)
                    }
                )
            }

            item { HorizontalDivider(modifier = Modifier.padding(top = 8.dp)) }

            item { SectionLabel("Вертикальная цветная черта (индикатор через drawWithContent)") }
            item {
                val primaryColor = MaterialTheme.colorScheme.primary
                ListItem(
                    headlineContent = { Text("Важное уведомление") },
                    supportingContent = { Text("Индикатор основного цвета слева") },
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        drawRect(
                            color = primaryColor,
                            topLeft = Offset.Zero,
                            size = Size(4.dp.toPx(), size.height)
                        )
                    }
                )
            }
            item {
                val errorColor = MaterialTheme.colorScheme.error
                ListItem(
                    headlineContent = { Text("Критическая ошибка") },
                    supportingContent = { Text("Красный индикатор — высокий приоритет") },
                    leadingContent = {
                        Icon(
                            Icons.Outlined.Warning,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    },
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        drawRect(
                            color = errorColor,
                            topLeft = Offset.Zero,
                            size = Size(4.dp.toPx(), size.height)
                        )
                    }
                )
            }
            item {
                val tertiaryColor = MaterialTheme.colorScheme.tertiary
                ListItem(
                    headlineContent = { Text("Информация") },
                    supportingContent = { Text("Бирюзовый индикатор — информационный") },
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        drawRect(
                            color = tertiaryColor,
                            topLeft = Offset.Zero,
                            size = Size(4.dp.toPx(), size.height)
                        )
                    }
                )
            }

            item { HorizontalDivider(modifier = Modifier.padding(top = 8.dp)) }

            item { SectionLabel("VerticalDivider внутри ведущего контента") }
            item {
                ListItem(
                    headlineContent = { Text("Статус: Активен") },
                    supportingContent = { Text("VerticalDivider как цветовой маркер") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .width(4.dp)
                                .height(40.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = MaterialTheme.shapes.small
                                )
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Статус: На паузе") },
                    supportingContent = { Text("Оранжевый маркер — ожидание") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .width(4.dp)
                                .height(40.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.tertiary,
                                    shape = MaterialTheme.shapes.small
                                )
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Статус: Ошибка") },
                    supportingContent = { Text("Красный маркер — требует внимания") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .width(4.dp)
                                .height(40.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.error,
                                    shape = MaterialTheme.shapes.small
                                )
                        )
                    }
                )
            }

            item { HorizontalDivider(modifier = Modifier.padding(top = 8.dp)) }

            item { SectionLabel("VerticalDivider как разделитель в строке") }
            item {
                SplitRow()
            }
        }
    }
}

@Composable
private fun SplitRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        ListItem(
            headlineContent = { Text("Левая часть") },
            modifier = Modifier.weight(1f)
        )
        VerticalDivider(modifier = Modifier.fillMaxHeight())
        ListItem(
            headlineContent = { Text("Правая часть") },
            modifier = Modifier.weight(1f)
        )
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
