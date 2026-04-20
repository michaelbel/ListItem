@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem.sample02_ListItem_Expressive

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.michaelbel.listitem.SectionLabel

@Composable
fun Sample02App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = "ListItem Expressive") },
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
                start = 16.dp,
                top = innerPadding.calculateTopPadding(),
                end = 16.dp,
                bottom = innerPadding.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            item { SectionLabel("onClick") }
            item {
                ListItem(
                    onClick = { Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show() },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Кликабельный элемент") }
            }
            item { SectionLabel("enabled") }
            item {
                ListItem(
                    onClick = {},
                    enabled = true,
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "enabled = true") }
            }
            item {
                ListItem(
                    onClick = {},
                    enabled = false,
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "enabled = false") }
            }
            item { SectionLabel("leadingContent") }
            item {
                ListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    supportingContent = { Text(text = "Size 24.dp") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Icon") }
            }
            item {
                ListItem(
                    onClick = {},
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
                    supportingContent = { Text("Size 40.dp") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Avatar") }
            }
            item {
                ListItem(
                    onClick = {},
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
                    supportingContent = { Text(text = "Size 56.dp") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Thumbnail") }
            }
            item { SectionLabel(text = "trailingContent") }
            item {
                ListItem(
                    onClick = {},
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
                ) { Text(text = "Иконка-стрелка") }
            }
            item {
                var checked by remember { mutableStateOf(true) }

                ListItem(
                    onClick = { checked = !checked },
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
                ) { Text("Switch") }
            }
            item {
                var checked by remember { mutableStateOf(true) }

                ListItem(
                    onClick = { checked = !checked },
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
                ) { Text("Checkbox") }
            }
            item {
                var selected by remember { mutableStateOf(true) }

                ListItem(
                    onClick = { selected = !selected },
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
                ) { Text("RadioButton") }
            }
            item { SectionLabel(text = "overlineContent") }
            item {
                ListItem(
                    onClick = {},
                    overlineContent = {
                        Text(
                            text = "КАТЕГОРИЯ"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "overline") }
            }
            item {
                ListItem(
                    onClick = {},
                    overlineContent = {
                        Text(
                            text = "КАТЕГОРИЯ"
                        )
                    },
                    supportingContent = { Text(text = "Вспомогательный текст") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "overline + supporting") }
            }
            item { SectionLabel(text = "supportingContent") }
            item {
                ListItem(
                    onClick = {},
                    supportingContent = {
                        Text(
                            text = "Одна строка текста"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Однострочный") }
            }
            item {
                ListItem(
                    onClick = {},
                    supportingContent = {
                        Text(
                            text = "Длинный вспомогательный текст на несколько строк, который переносится на следующую строку"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Многострочный") }
            }
            item { SectionLabel(text = "verticalAlignment") }
            item {
                ListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    supportingContent = {
                        Text(
                            text = "Иконка выровнена по верхнему краю"
                        )
                    },
                    verticalAlignment = Alignment.Top,
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Alignment.Top") }
            }
            item {
                ListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    supportingContent = {
                        Text(
                            text = "Иконка выровнена по центру — по умолчанию"
                        )
                    },
                    verticalAlignment = Alignment.CenterVertically,
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Alignment.CenterVertically") }
            }
            item { SectionLabel(text = "onLongClick") }
            item {
                ListItem(
                    onClick = { Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show() },
                    onLongClick = { Toast.makeText(context, "onLongClick", Toast.LENGTH_SHORT).show() },
                    onLongClickLabel = "Долгое нажатие",
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Кликабельный элемент") }
            }
            item { SectionLabel(text = "shapes") }
            item {
                ListItem(
                    onClick = {},
                    shapes = ListItemDefaults.shapes(shape = RoundedCornerShape(50.dp)),
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "shape = RoundedCornerShape(50.dp)") }
            }
            item {
                ListItem(
                    onClick = {},
                    shapes = ListItemDefaults.shapes(pressedShape = RoundedCornerShape(50.dp)),
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "pressedShape = RoundedCornerShape(50.dp)") }
            }
            item { SectionLabel(text = "colors") }
            item {
                ListItem(
                    onClick = {},
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) { Text("containerColor") }
            }
            item {
                ListItem(
                    onClick = {},
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        contentColor = MaterialTheme.colorScheme.tertiary,
                    )
                ) { Text("contentColor") }
            }
            item {
                ListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        leadingContentColor = MaterialTheme.colorScheme.tertiary,
                    )
                ) { Text("leadingContentColor") }
            }
            item {
                ListItem(
                    onClick = {},
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        trailingContentColor = MaterialTheme.colorScheme.tertiary,
                    )
                ) { Text("trailingContentColor") }
            }
            item {
                ListItem(
                    onClick = {},
                    overlineContent = {
                        Text(
                            text = "КАТЕГОРИЯ"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        overlineContentColor = MaterialTheme.colorScheme.tertiary,
                    )
                ) { Text("overlineContentColor") }
            }
            item {
                ListItem(
                    onClick = {},
                    supportingContent = {
                        Text(
                            text = "supportingContent"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        supportingContentColor = MaterialTheme.colorScheme.tertiary,
                    )
                ) { Text("supportingContentColor") }
            }
            item { SectionLabel(text = "elevation") }
            item {
                ListItem(
                    onClick = {},
                    elevation = ListItemDefaults.elevation(elevation = 16.dp),
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Elevation — 16.dp") }
            }
            item { SectionLabel(text = "contentPadding") }
            item {
                ListItem(
                    onClick = {},
                    overlineContent = { Text(text = "ContentPadding Compact") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) { Text(text = "horizontal = 8.dp, vertical = 4.dp") }
            }
            item {
                ListItem(
                    onClick = {},
                    overlineContent = { Text(text = "ContentPadding Large") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 20.dp)
                ) { Text(text = "horizontal = 32.dp, vertical = 20.dp") }
            }
            item { SectionLabel(text = "interactionSource") }
            item {
                val interactionSource = remember { MutableInteractionSource() }
                val isPressed by interactionSource.collectIsPressedAsState()

                ListItem(
                    onClick = {},
                    interactionSource = interactionSource,
                    supportingContent = { Text(text = "Нажми и удерживай") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = if (isPressed) "Нажато!" else "interactionSource") }
            }
        }
    }
}
