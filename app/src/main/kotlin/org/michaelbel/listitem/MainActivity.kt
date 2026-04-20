@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.michaelbel.listitem.sample01_ListItem.Sample01App
import org.michaelbel.listitem.sample02_ListItem_Expressive.Sample02App
import org.michaelbel.listitem.sample03_ListItem_Expressive_Selected.Sample03App
import org.michaelbel.listitem.sample04_ListItem_Expressive_Checked.Sample04App
import org.michaelbel.listitem.sample05_SegmentedListItem.Sample05App
import org.michaelbel.listitem.sample06_SegmentedListItem_Selected.Sample06App
import org.michaelbel.listitem.sample07_SegmentedListItem_Checked.Sample07App

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var selectedSample by rememberSaveable { mutableStateOf<Int?>(null) }
                when {
                    selectedSample == null -> SamplesListScreen { selectedSample = it }
                    else -> {
                        BackHandler { selectedSample = null }
                        when (selectedSample) {
                            0 -> Sample01App()
                            1 -> Sample02App()
                            2 -> Sample03App()
                            3 -> Sample04App()
                            4 -> Sample05App()
                            5 -> Sample06App()
                            6 -> Sample07App()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SamplesListScreen(onSampleClick: (Int) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
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
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            item {
                SegmentedListItem(
                    onClick = { onSampleClick(0) },
                    overlineContent = { Text(text = "Sample 01") },
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 1),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "ListItem") }
            }
            item {
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
            item {
                SegmentedListItem(
                    onClick = { onSampleClick(1) },
                    overlineContent = { Text(text = "Sample 02") },
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "ListItem Expressive") }
            }
            item {
                SegmentedListItem(
                    onClick = { onSampleClick(2) },
                    overlineContent = { Text(text = "Sample 03") },
                    shapes = ListItemDefaults.segmentedShapes(index = 1, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "ListItem Expressive Selected") }
            }
            item {
                SegmentedListItem(
                    onClick = { onSampleClick(3) },
                    overlineContent = { Text(text = "Sample 04") },
                    shapes = ListItemDefaults.segmentedShapes(index = 2, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "ListItem Expressive Checked") }
            }
            item {
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
            item {
                SegmentedListItem(
                    onClick = { onSampleClick(4) },
                    overlineContent = { Text(text = "Sample 05") },
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "SegmentedListItem") }
            }
            item {
                SegmentedListItem(
                    onClick = { onSampleClick(5) },
                    overlineContent = { Text(text = "Sample 06") },
                    shapes = ListItemDefaults.segmentedShapes(index = 1, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "SegmentedListItem Selected") }
            }
            item {
                SegmentedListItem(
                    onClick = { onSampleClick(6) },
                    overlineContent = { Text(text = "Sample 07") },
                    shapes = ListItemDefaults.segmentedShapes(index = 2, count = 3),
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "SegmentedListItem Checked") }
            }
        }
    }
}
