@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.listitem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
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
import org.michaelbel.listitem.sample01_BasicText.Sample01App
import org.michaelbel.listitem.sample02_LeadingContent.Sample02App
import org.michaelbel.listitem.sample03_TrailingContent.Sample03App
import org.michaelbel.listitem.sample04_Switch.Sample04App
import org.michaelbel.listitem.sample05_Checkbox.Sample05App
import org.michaelbel.listitem.sample06_RadioButton.Sample06App
import org.michaelbel.listitem.sample07_Dividers.Sample07App
import org.michaelbel.listitem.sample08_States.Sample08App
import org.michaelbel.listitem.sample09_Colors.Sample09App
import org.michaelbel.listitem.sample10_RealWorld.Sample10App
import org.michaelbel.listitem.sample11_FullCatalog.Sample11App

class MainActivity : ComponentActivity() {

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

private data class SampleEntry(val number: String, val title: String, val description: String)

private val samples = listOf(
    SampleEntry("01", "Текстовые варианты", "headline, overline, supporting — все комбинации"),
    SampleEntry("02", "Ведущий контент", "Иконки, аватары, миниатюры в leadingContent"),
    SampleEntry("03", "Концевой контент", "Иконки, текст, кнопки, бейджи в trailingContent"),
    SampleEntry("04", "Switch", "Переключатель: базовый, с иконкой, с текстом, disabled"),
    SampleEntry("05", "Checkbox", "Флажок: trailing, leading, indeterminate, «Выбрать всё»"),
    SampleEntry("06", "RadioButton", "Одиночный выбор: базовый, с текстом, с иконкой"),
    SampleEntry("07", "Разделители", "HorizontalDivider, inset, заголовки секций, черта, VerticalDivider"),
    SampleEntry("08", "Состояния", "Кликабельный, выбранный, избранное, disabled"),
    SampleEntry("09", "Цвета", "ListItemDefaults.colors(), tonal & shadow elevation"),
    SampleEntry("10", "Реальные сценарии", "Чаты, контакты, файлы, треки, настройки"),
    SampleEntry("11", "Полный каталог", "Все варианты в одном прокручиваемом списке")
)

@Composable
private fun SamplesListScreen(onSampleClick: (Int) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("ListItem Samples") },
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
                bottom = 16.dp + WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            samples.forEachIndexed { index, sample ->
                item(key = index) {
                    val shape = when (index) {
                        0 -> topListItemShape
                        samples.lastIndex -> bottomListItemShape
                        else -> middleExtraSmallListItemShape
                    }
                    ListItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape)
                            .clickable { onSampleClick(index) },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        ),
                        overlineContent = { Text("Sample ${sample.number}") },
                        headlineContent = { Text(sample.title) },
                        supportingContent = { Text(sample.description) }
                    )
                }
            }
        }
    }
}
