@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem.sample06_SegmentedListItem_Selected

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HighQuality
import androidx.compose.material.icons.outlined.NetworkCell
import androidx.compose.material.icons.outlined.Sd
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedListItem
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
fun Sample06App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var qualityIndex by rememberSaveable { mutableIntStateOf(1) }

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
            item { SectionLabel("Качество видео") }
            item {
                SegmentedListItem(
                    selected = qualityIndex == 0,
                    onClick = { qualityIndex = 0 },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.HighQuality,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        RadioButton(
                            selected = qualityIndex == 0,
                            onClick = { qualityIndex = 0 }
                        )
                    },
                    supportingContent = { Text("1080p · ~4 ГБ/ч") },
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Высокое качество") }
            }
            item {
                SegmentedListItem(
                    selected = qualityIndex == 1,
                    onClick = { qualityIndex = 1 },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Speed,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        RadioButton(
                            selected = qualityIndex == 1,
                            onClick = { qualityIndex = 1 }
                        )
                    },
                    supportingContent = { Text("720p · ~2 ГБ/ч") },
                    shapes = ListItemDefaults.segmentedShapes(index = 1, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Среднее качество") }
            }
            item {
                SegmentedListItem(
                    selected = qualityIndex == 2,
                    onClick = { qualityIndex = 2 },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.NetworkCell,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        RadioButton(
                            selected = qualityIndex == 2,
                            onClick = { qualityIndex = 2 }
                        )
                    },
                    supportingContent = { Text("480p · ~0.7 ГБ/ч") },
                    shapes = ListItemDefaults.segmentedShapes(index = 2, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Экономия трафика") }
            }
            item {
                SegmentedListItem(
                    selected = qualityIndex == 3,
                    onClick = { qualityIndex = 3 },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Outlined.Sd,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        RadioButton(
                            selected = qualityIndex == 3,
                            onClick = { qualityIndex = 3 }
                        )
                    },
                    supportingContent = { Text("144p · ~0.1 ГБ/ч") },
                    shapes = ListItemDefaults.segmentedShapes(index = 3, count = 4),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text("Минимальное качество") }
            }
        }
    }
}
