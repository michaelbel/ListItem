@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample02_LeadingContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
fun Sample02App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Ведущий контент") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Стандартная иконка (24 dp)") }
            item {
                ListItem(
                    headlineContent = { Text("Email") },
                    supportingContent = { Text("Стандартный размер иконки") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    supportingContent = { Text("Ещё один пример с иконкой") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = null
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Настройки") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Увеличенная иконка (40 dp)") }
            item {
                ListItem(
                    headlineContent = { Text("Аккаунт") },
                    supportingContent = { Text("Иконка 40 dp — как аватар") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Галерея") },
                    supportingContent = { Text("Камера 40 dp") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.PhotoCamera,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Буквенный аватар") }
            item {
                ListItem(
                    headlineContent = { Text("Алексей Смирнов") },
                    supportingContent = { Text("Инициал на цветном фоне") },
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
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Мария Иванова") },
                    supportingContent = { Text("Второй аватар — другой цвет") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.tertiaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "М",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Миниатюра (56 dp, скруглённые углы)") }
            item {
                ListItem(
                    headlineContent = { Text("Плейлист «Рок»") },
                    supportingContent = { Text("24 трека · 1 ч 42 мин") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.MusicNote,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Документы") },
                    supportingContent = { Text("128 файлов · 2.4 ГБ") },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.tertiaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Folder,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onTertiaryContainer,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Иконка + надстрочный текст + вспомогательный") }
            item {
                ListItem(
                    headlineContent = { Text("Главная страница") },
                    overlineContent = { Text("НАВИГАЦИЯ") },
                    supportingContent = { Text("Перейти на главный экран приложения") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
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
