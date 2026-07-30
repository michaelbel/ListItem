package org.michaelbel.listitem

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.michaelbel.listitem.sample01_ListItem.Sample01App
import org.michaelbel.listitem.sample02_ListItem_Expressive.Sample02App
import org.michaelbel.listitem.sample03_ListItem_Expressive_Selected.Sample03App
import org.michaelbel.listitem.sample04_ListItem_Expressive_Checked.Sample04App
import org.michaelbel.listitem.sample05_SegmentedListItem.Sample05App
import org.michaelbel.listitem.sample06_SegmentedListItem_Selected.Sample06App
import org.michaelbel.listitem.sample07_SegmentedListItem_Checked.Sample07App
import org.michaelbel.listitem.sample08_SegmentedGap.Sample08App

private data object Home
private data object Sample01
private data object Sample02
private data object Sample03
private data object Sample04
private data object Sample05
private data object Sample06
private data object Sample07
private data object Sample08

@Composable
fun MainActivityContent() {
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        popTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        predictivePopTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        entryProvider = entryProvider {
            entry<Home> {
                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "ListItem Samples") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                            ),
                            scrollBehavior = scrollBehavior
                        )
                    },
                    contentWindowInsets = ScaffoldDefaults.contentWindowInsets.only(WindowInsetsSides.Horizontal)
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPadding),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
                        ),
                        verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
                    ) {
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample01) },
                                overlineContent = { Text(text = "Sample 01") },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 1),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "ListItem") }
                            )
                        }

                        item {
                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )
                        }

                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample02) },
                                overlineContent = { Text(text = "Sample 02") },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 3),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "ListItem Expressive") }
                            )
                        }

                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample03) },
                                overlineContent = { Text(text = "Sample 03") },
                                shapes = ListItemDefaults.segmentedShapes(index = 1, count = 3),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "ListItem Expressive Selected") }
                            )
                        }

                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample04) },
                                overlineContent = { Text(text = "Sample 04") },
                                shapes = ListItemDefaults.segmentedShapes(index = 2, count = 3),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "ListItem Expressive Checked") }
                            )
                        }

                        item {
                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )
                        }

                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample05) },
                                overlineContent = { Text(text = "Sample 05") },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 3),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "SegmentedListItem") }
                            )
                        }

                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample06) },
                                overlineContent = { Text(text = "Sample 06") },
                                shapes = ListItemDefaults.segmentedShapes(index = 1, count = 3),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "SegmentedListItem Selected") }
                            )
                        }

                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample07) },
                                overlineContent = { Text(text = "Sample 07") },
                                shapes = ListItemDefaults.segmentedShapes(index = 2, count = 3),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "SegmentedListItem Checked") }
                            )
                        }

                        item {
                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )
                        }

                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample08) },
                                overlineContent = { Text(text = "Sample 08") },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 1),
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "SegmentedGap") }
                            )
                        }
                    }
                }
            }
            entry<Sample01> { Sample01App() }
            entry<Sample02> { Sample02App() }
            entry<Sample03> { Sample03App() }
            entry<Sample04> { Sample04App() }
            entry<Sample05> { Sample05App() }
            entry<Sample06> { Sample06App() }
            entry<Sample07> { Sample07App() }
            entry<Sample08> { Sample08App() }
        }
    )
}
