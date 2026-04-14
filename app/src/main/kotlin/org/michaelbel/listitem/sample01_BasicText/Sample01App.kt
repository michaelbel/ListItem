@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem.sample01_BasicText

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
fun Sample01App() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Текстовые варианты") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { SectionLabel("Только заголовок") }
            item {
                ListItem(
                    headlineContent = { Text("Headline Content") }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Заголовок + вспомогательный текст") }
            item {
                ListItem(
                    headlineContent = { Text("Headline Content") },
                    supportingContent = { Text("Supporting Content") }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Надстрочный текст + заголовок") }
            item {
                ListItem(
                    headlineContent = { Text("Headline Content") },
                    overlineContent = { Text("OVERLINE") }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Надстрочный + заголовок + вспомогательный") }
            item {
                ListItem(
                    headlineContent = { Text("Headline Content") },
                    overlineContent = { Text("OVERLINE") },
                    supportingContent = { Text("Supporting Content") }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Трёхстрочный — длинный вспомогательный текст") }
            item {
                ListItem(
                    headlineContent = { Text("Headline Content") },
                    supportingContent = {
                        Text(
                            "Supporting text that wraps across multiple lines, " +
                                "demonstrating the three-line list item variant in Material Design 3"
                        )
                    }
                )
            }

            item { HorizontalDivider() }

            item { SectionLabel("Трёхстрочный с надстрочным текстом") }
            item {
                ListItem(
                    headlineContent = { Text("Headline Content") },
                    overlineContent = { Text("CATEGORY") },
                    supportingContent = {
                        Text(
                            "Supporting text that wraps across multiple lines, " +
                                "showing the full three-line variant with overline"
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
