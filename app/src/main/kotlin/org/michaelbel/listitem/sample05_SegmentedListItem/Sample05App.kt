@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem.sample05_SegmentedListItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Reply
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import org.michaelbel.listitem.SectionLabel

@Composable
fun Sample05App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("SegmentedListItem") },
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
            item { SectionLabel("Действия с письмом") }
            item {
                SegmentedListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Reply,
                            contentDescription = null
                        )
                    },
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Ответить") }
            }
            item {
                SegmentedListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    supportingContent = { Text("Переслать всем адресатам") },
                    shapes = ListItemDefaults.segmentedShapes(index = 1, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Переслать") }
            }
            item {
                SegmentedListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Archive,
                            contentDescription = null
                        )
                    },
                    shapes = ListItemDefaults.segmentedShapes(index = 2, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Архивировать") }
            }
            item {
                SegmentedListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = null
                        )
                    },
                    shapes = ListItemDefaults.segmentedShapes(index = 3, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Удалить") }
            }
        }
    }
}
