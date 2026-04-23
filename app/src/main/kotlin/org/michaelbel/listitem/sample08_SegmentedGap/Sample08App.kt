@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem.sample08_SegmentedGap

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Reply
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.michaelbel.listitem.SectionLabel
import kotlin.math.roundToInt

@Composable
fun Sample08App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val gapSteps: List<Dp> = listOf(ListItemDefaults.SegmentedGap, 4.dp, 6.dp, 8.dp, 10.dp, 12.dp, 14.dp, 16.dp)
    var sliderValue by remember { mutableFloatStateOf(0f) }
    val gapIndex = sliderValue.roundToInt().coerceIn(gapSteps.indices)
    val animatedGap by animateDpAsState(
        targetValue = gapSteps[gapIndex],
        animationSpec = spring(),
        label = "gap"
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("SegmentedGap") },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            val interactionSource = remember { MutableInteractionSource() }

            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0F..7F,
                steps = 6,
                interactionSource = interactionSource,
                thumb = { state ->
                    val index = state.value.roundToInt().coerceIn(gapSteps.indices)

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${gapSteps[index].value.toInt()}dp",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )

                        SliderDefaults.Thumb(
                            interactionSource = interactionSource
                        )
                    }
                },
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding + PaddingValues(
                start = 16.dp,
                end = 16.dp,
                bottom = 88.dp
            ),
            verticalArrangement = Arrangement.spacedBy(animatedGap)
        ) {
            item { SectionLabel("Действия с письмом") }
            item {
                SegmentedListItem(
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.Reply,
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
