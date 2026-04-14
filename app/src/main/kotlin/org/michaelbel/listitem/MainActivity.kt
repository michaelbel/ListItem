@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.michaelbel.listitem.sample01_Scaffold_BottomBar.Sample01App
import org.michaelbel.listitem.sample02_NavigationSuiteScaffold_NavigationBar.Sample02App
import org.michaelbel.listitem.sample03_NavigationSuiteScaffold_NavigationRail.Sample03App
import org.michaelbel.listitem.sample04_NavigationSuiteScaffold_NavigationRail_NoLabels.Sample04App
import org.michaelbel.listitem.sample05_NavigationSuiteScaffold_NavigationRail_Expanded.Sample05App
import org.michaelbel.listitem.sample06_NavigationSuiteScaffold_NavigationRail_VerticalArrangement.Sample06App
import org.michaelbel.listitem.sample07_NavigationSuiteScaffold_NavigationRail_Expanded_State.Sample07App
import org.michaelbel.listitem.sample08_NavigationSuiteScaffold_PrimaryActionContent.Sample08App
import org.michaelbel.listitem.sample09_NavigationSuiteScaffold_Colors.Sample09App
import org.michaelbel.listitem.sample10_NavigationSuiteScaffold_NavigationSuite.Sample10App
import org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.Sample11App

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
                            7 -> Sample08App()
                            8 -> Sample09App()
                            9 -> Sample10App()
                            10 -> Sample11App()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SamplesListScreen(
    onSampleClick: (Int) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = "NavigationSuiteScaffold") },
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
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleLargeIncreasedListItemShape)
                        .clickable { onSampleClick(0) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 01") },
                    headlineContent = { Text(text = "Classic Scaffold BottomBar") }
                )
            }

            item {
                Spacer(
                    modifier = Modifier.height(14.dp)
                )
            }

            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(topListItemShape)
                        .clickable { onSampleClick(1) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 02") },
                    headlineContent = { Text(text = "NavigationSuiteScaffold NavigationBar") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(2) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 03") },
                    headlineContent = { Text(text = "NavigationSuiteScaffold NavigationRail") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(3) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 04") },
                    headlineContent = { Text(text = "NavigationRail NoLabels") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(4) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 05") },
                    headlineContent = { Text(text = "NavigationRail Expanded") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(5) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 06") },
                    headlineContent = { Text(text = "NavigationRail VerticalArrangement") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(6) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 07") },
                    headlineContent = { Text(text = "NavigationRail Expanded State") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(7) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 08") },
                    headlineContent = { Text(text = "PrimaryActionContent") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(8) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 09") },
                    headlineContent = { Text(text = "Colors") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleExtraSmallListItemShape)
                        .clickable { onSampleClick(9) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 10") },
                    headlineContent = { Text(text = "NavigationSuite") }
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(bottomListItemShape)
                        .clickable { onSampleClick(10) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    overlineContent = { Text(text = "Sample 11") },
                    headlineContent = { Text(text = "NavigationSuiteScaffoldLayout") }
                )
            }
        }
    }
}
