@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample10_RealWorld

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.automirrored.outlined.InsertDriveFile
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun Sample10App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Реальные сценарии") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // ─── Мессенджер ──────────────────────────────────────────────
            item { SectionLabel("Список чатов (мессенджер)") }
            item {
                data class Chat(
                    val name: String,
                    val preview: String,
                    val time: String,
                    val unread: Int,
                    val initial: String,
                    val containerColorIndex: Int
                )
                val chats = listOf(
                    Chat("Алексей Смирнов", "Ок, буду в 18:00", "14:23", 0, "А", 0),
                    Chat("Команда разработки", "Артём: Пулл-реквест одобрен ✓", "13:45", 3, "К", 1),
                    Chat("Мария Иванова", "Ты видел новый Material 3?", "Вт", 1, "М", 2),
                    Chat("Иван Петров", "Спасибо за помощь!", "Пн", 0, "И", 0)
                )
                chats.forEach { chat ->
                    val containerColors = listOf(
                        MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer,
                        MaterialTheme.colorScheme.tertiaryContainer to MaterialTheme.colorScheme.onTertiaryContainer
                    )
                    val (bgColor, textColor) = containerColors[chat.containerColorIndex]
                    ListItem(
                        headlineContent = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = chat.name,
                                    fontWeight = if (chat.unread > 0) FontWeight.Bold else FontWeight.Normal
                                )
                                Text(
                                    text = chat.time,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = if (chat.unread > 0)
                                        MaterialTheme.colorScheme.primary
                                    else
                                        MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        },
                        supportingContent = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = chat.preview,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f)
                                )
                                if (chat.unread > 0) {
                                    Badge {
                                        Text(chat.unread.toString())
                                    }
                                }
                            }
                        },
                        leadingContent = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(bgColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = chat.initial,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = textColor
                                )
                            }
                        },
                        modifier = Modifier.clickable { /* open chat */ }
                    )
                    HorizontalDivider(modifier = Modifier.padding(start = 80.dp))
                }
            }

            // ─── Контакты ─────────────────────────────────────────────────
            item { SectionLabel("Список контактов") }
            item {
                data class Contact(val name: String, val role: String, val initial: String)
                val contacts = listOf(
                    Contact("Алексей Смирнов", "Руководитель проекта", "А"),
                    Contact("Мария Иванова", "Дизайнер", "М"),
                    Contact("Сергей Козлов", "Backend-разработчик", "С"),
                    Contact("Анна Новикова", "QA-инженер", "А")
                )
                contacts.forEach { contact ->
                    ListItem(
                        headlineContent = { Text(contact.name) },
                        supportingContent = { Text(contact.role) },
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },
                        trailingContent = {
                            Icon(
                                Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier.clickable { /* open contact */ }
                    )
                }
            }

            item { HorizontalDivider() }

            // ─── Файлы ────────────────────────────────────────────────────
            item { SectionLabel("Менеджер файлов") }
            item {
                data class FileItem(
                    val name: String,
                    val size: String,
                    val date: String
                )
                val files = listOf(
                    FileItem("project_report.pdf", "2.4 МБ", "14 апр"),
                    FileItem("design_mockups.fig", "18.7 МБ", "12 апр"),
                    FileItem("meeting_notes.docx", "128 КБ", "10 апр"),
                    FileItem("database_backup.sql", "45.2 МБ", "8 апр")
                )
                files.forEach { file ->
                    ListItem(
                        headlineContent = { Text(file.name, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                        supportingContent = { Text("${file.size} · ${file.date}") },
                        leadingContent = {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(MaterialTheme.colorScheme.surfaceContainerHighest),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Outlined.InsertDriveFile,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        },
                        trailingContent = {
                            Row {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Outlined.Share, contentDescription = "Поделиться")
                                }
                                IconButton(onClick = {}) {
                                    Icon(Icons.Outlined.Download, contentDescription = "Скачать")
                                }
                            }
                        },
                        modifier = Modifier.clickable { /* open file */ }
                    )
                    HorizontalDivider()
                }
            }

            // ─── Музыкальный плеер ────────────────────────────────────────
            item { SectionLabel("Треклист") }
            item {
                data class Track(val title: String, val artist: String, val duration: String)
                val tracks = listOf(
                    Track("Bohemian Rhapsody", "Queen", "5:54"),
                    Track("Stairway to Heaven", "Led Zeppelin", "8:02"),
                    Track("Hotel California", "Eagles", "6:30"),
                    Track("Imagine", "John Lennon", "3:04")
                )
                var playing by remember { mutableStateOf<String?>(tracks[0].title) }
                tracks.forEach { track ->
                    val isPlaying = playing == track.title
                    ListItem(
                        headlineContent = {
                            Text(
                                text = track.title,
                                fontWeight = if (isPlaying) FontWeight.Bold else FontWeight.Normal,
                                color = if (isPlaying) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.onSurface
                            )
                        },
                        supportingContent = { Text(track.artist) },
                        leadingContent = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(
                                        if (isPlaying) MaterialTheme.colorScheme.primaryContainer
                                        else MaterialTheme.colorScheme.surfaceContainerHighest
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    Icons.Outlined.MusicNote,
                                    contentDescription = null,
                                    tint = if (isPlaying) MaterialTheme.colorScheme.onPrimaryContainer
                                    else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        },
                        trailingContent = {
                            Text(
                                text = track.duration,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        },
                        modifier = Modifier.clickable { playing = track.title }
                    )
                    HorizontalDivider()
                }
            }

            // ─── Настройки ────────────────────────────────────────────────
            item { SectionLabel("Экран настроек") }
            item {
                Text(
                    text = "ПОДКЛЮЧЕНИЯ",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 8.dp, bottom = 4.dp)
                )
                var wifi by rememberSaveable { mutableStateOf(true) }
                var bluetooth by rememberSaveable { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Wi-Fi") },
                    supportingContent = { Text(if (wifi) "Home_Network_5G" else "Выключено") },
                    leadingContent = { Icon(Icons.Outlined.Wifi, contentDescription = null) },
                    trailingContent = { Switch(checked = wifi, onCheckedChange = { wifi = it }) }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 16.dp))
                ListItem(
                    headlineContent = { Text("Bluetooth") },
                    supportingContent = { Text(if (bluetooth) "Включено" else "Выключено") },
                    leadingContent = { Icon(Icons.Outlined.Bluetooth, contentDescription = null) },
                    trailingContent = {
                        Switch(checked = bluetooth, onCheckedChange = { bluetooth = it })
                    }
                )

                Text(
                    text = "АККАУНТ",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
                )
                ListItem(
                    headlineContent = { Text("Профиль") },
                    supportingContent = { Text("aleksey.smirnov@mail.ru") },
                    leadingContent = {
                        Icon(Icons.Outlined.Person, contentDescription = null)
                    },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 16.dp))
                ListItem(
                    headlineContent = { Text("Безопасность") },
                    supportingContent = { Text("Пароль, биометрия") },
                    leadingContent = {
                        Icon(Icons.Outlined.Security, contentDescription = null)
                    },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { }
                )

                Text(
                    text = "УСТРОЙСТВО",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
                )
                var darkMode by rememberSaveable { mutableStateOf(false) }
                ListItem(
                    headlineContent = { Text("Тёмная тема") },
                    leadingContent = { Icon(Icons.Outlined.DarkMode, contentDescription = null) },
                    trailingContent = {
                        Switch(checked = darkMode, onCheckedChange = { darkMode = it })
                    }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 16.dp))
                ListItem(
                    headlineContent = { Text("Язык") },
                    supportingContent = { Text("Русский") },
                    leadingContent = { Icon(Icons.Outlined.Language, contentDescription = null) },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 16.dp))
                ListItem(
                    headlineContent = { Text("Хранилище") },
                    supportingContent = { Text("12.4 ГБ из 64 ГБ использовано") },
                    leadingContent = { Icon(Icons.Outlined.Storage, contentDescription = null) },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 16.dp))
                ListItem(
                    headlineContent = { Text("Уведомления") },
                    leadingContent = {
                        Icon(Icons.Outlined.Notifications, contentDescription = null)
                    },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { }
                )

                Text(
                    text = "ДАННЫЕ",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
                )
                ListItem(
                    headlineContent = { Text("Настройки") },
                    supportingContent = { Text("Сбросить до заводских") },
                    leadingContent = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.clickable { }
                )
                HorizontalDivider(modifier = Modifier.padding(start = 16.dp))
                ListItem(
                    headlineContent = { Text("Удалить аккаунт") },
                    supportingContent = { Text("Действие необратимо") },
                    leadingContent = {
                        Icon(
                            Icons.Outlined.Delete,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    },
                    modifier = Modifier.clickable { }
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
