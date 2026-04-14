package org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.michaelbel.listitem.AppRoute
import org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.details.DetailsScreen
import org.michaelbel.listitem.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.main.MainScreen

@Composable
fun Sample11App() {
    val backStack = rememberNavBackStack(AppRoute.Home)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        popTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        predictivePopTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        entryDecorators = listOf(rememberSaveableStateHolderNavEntryDecorator()),
        entryProvider = entryProvider {
            entry<AppRoute.Home> {
                MainScreen(
                    onNavigateToDetails = { boarId -> backStack.add(AppRoute.Details(boarId)) }
                )
            }
            entry<AppRoute.Details> { route -> DetailsScreen(route) }
        }
    )
}
