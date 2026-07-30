package org.michaelbel.listitem.sample03_ListItem_Expressive_Selected

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import org.michaelbel.listitem.SectionLabel

@Composable
fun Sample03App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var selectedTheme by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("ListItem Expressive Selected") },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding + PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item { SectionLabel("Тема") }
            item {
                ListItem(
                    selected = selectedTheme == 0,
                    onClick = { selectedTheme = 0 },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.LightMode,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        RadioButton(
                            selected = selectedTheme == 0,
                            onClick = { selectedTheme = 0 }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Светлая") }
            }
            item {
                ListItem(
                    selected = selectedTheme == 1,
                    onClick = { selectedTheme = 1 },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.DarkMode,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        RadioButton(
                            selected = selectedTheme == 1,
                            onClick = { selectedTheme = 1 }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Темная") }
            }
            item {
                ListItem(
                    selected = selectedTheme == 2,
                    onClick = { selectedTheme = 2 },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.PhoneAndroid,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        RadioButton(
                            selected = selectedTheme == 2,
                            onClick = { selectedTheme = 2 }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Системная") }
            }
        }
    }
}
