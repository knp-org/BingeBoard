package org.knp.bingeboard.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.knp.bingeboard.ui.components.GlassBottomNav
import org.knp.bingeboard.ui.screens.detail.DetailScreen
import org.knp.bingeboard.ui.screens.home.HomeScreen
import org.knp.bingeboard.ui.screens.search.SearchScreen
import org.knp.bingeboard.ui.screens.settings.SettingsScreen
import org.knp.bingeboard.ui.screens.tv.TvScreen

object Destinations {
    const val HOME = "home"
    const val TV = "tv"
    const val SETTINGS = "settings"
    const val SEARCH = "search"
    const val DETAIL = "detail/{mediaType}/{mediaId}?source={source}"

    fun detailRoute(mediaType: String, mediaId: Int, source: String = "tvmaze"): String =
        "detail/$mediaType/$mediaId?source=$source"
}

@Composable
fun BingeBoardNavGraph() {
    val navController = rememberNavController()
    var selectedNavIndex by rememberSaveable { mutableIntStateOf(0) }

    // Hide bottom nav on detail and search screens
    val currentEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentEntry?.destination?.route
    val showBottomNav = currentRoute in listOf(
        Destinations.HOME, Destinations.TV, Destinations.SETTINGS
    )

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = Destinations.HOME
        ) {
            composable(Destinations.HOME) {
                HomeScreen(
                    onShowClick = { id, source ->
                        navController.navigate(Destinations.detailRoute("tv", id, source))
                    },
                    onSearchClick = {
                        navController.navigate(Destinations.SEARCH)
                    }
                )
            }
            composable(Destinations.SETTINGS) {
                SettingsScreen()
            }
            composable(Destinations.TV) {
                TvScreen(
                    onShowClick = { id, source ->
                        navController.navigate(Destinations.detailRoute("tv", id, source))
                    },
                    onSearchClick = {
                        navController.navigate(Destinations.SEARCH)
                    }
                )
            }

            // Search screen
            composable(Destinations.SEARCH) {
                SearchScreen(
                    onBackClick = { navController.popBackStack() },
                    onResultClick = { mediaType, mediaId, source ->
                        navController.navigate(Destinations.detailRoute(mediaType, mediaId, source))
                    }
                )
            }

            // Detail screen
            composable(
                route = Destinations.DETAIL,
                arguments = listOf(
                    navArgument("mediaType") { type = NavType.StringType },
                    navArgument("mediaId") { type = NavType.IntType },
                    navArgument("source") {
                        type = NavType.StringType
                        defaultValue = "tvmaze"
                    }
                )
            ) {
                DetailScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

        if (showBottomNav) {
            GlassBottomNav(
                selectedIndex = selectedNavIndex,
                onItemSelected = { index ->
                    selectedNavIndex = index
                    val route = when (index) {
                        0 -> Destinations.HOME
                        1 -> Destinations.TV
                        2 -> Destinations.SETTINGS
                        else -> Destinations.HOME
                    }
                    navController.navigate(route) {
                        popUpTo(Destinations.HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
