@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample03_TrailingContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
fun Sample03App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Концевой контент") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Иконка навигации (стрелка вправо)") }
            item {
                ListItem(
                    headlineContent = { Text("Профиль") },
                    supportingContent = { Text("Настройки аккаунта") },
                    leadingContent = {
                        Icon(Icons.Outlined.Person, contentDescription = null)
                    },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    leadingContent = {
                        Icon(Icons.Outlined.Notifications, contentDescription = null)
                    },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Текст (метаданные)") }
            item {
                ListItem(
                    headlineContent = { Text("Мария Иванова") },
                    supportingContent = { Text("Привет, как дела?") },
                    trailingContent = {
                        Text(
                            text = "14:23",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Рабочий чат") },
                    supportingContent = { Text("Встреча в 16:00") },
                    trailingContent = {
                        Text(
                            text = "Вт",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Кнопка с иконкой (IconButton)") }
            item {
                ListItem(
                    headlineContent = { Text("Настройки системы") },
                    supportingContent = { Text("Версия 2.1.0") },
                    trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.MoreVert, contentDescription = "Ещё")
                        }
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Моя музыка") },
                    supportingContent = { Text("1 234 трека") },
                    trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.Download, contentDescription = "Скачать")
                        }
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Статья о Compose") },
                    supportingContent = { Text("Material Design 3") },
                    trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.Share, contentDescription = "Поделиться")
                        }
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Иконка действия (Favourite / Star)") }
            item {
                ListItem(
                    headlineContent = { Text("Избранный трек") },
                    supportingContent = { Text("Добавить в избранное") },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Добавить в избранное",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Оценить статью") },
                    supportingContent = { Text("Поставить звезду") },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.Outlined.StarBorder,
                            contentDescription = "Оценить",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Бейдж с числом непрочитанных") }
            item {
                ListItem(
                    headlineContent = { Text("Входящие") },
                    supportingContent = { Text("Непрочитанные сообщения") },
                    trailingContent = {
                        Badge {
                            Text("3")
                        }
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    supportingContent = { Text("Много новых событий") },
                    trailingContent = {
                        BadgedBox(badge = { Badge { Text("99+") } }) {}
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
