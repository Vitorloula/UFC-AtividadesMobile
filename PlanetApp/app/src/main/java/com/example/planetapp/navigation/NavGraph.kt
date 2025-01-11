package com.example.planetapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planetapp.models.planetList
import com.example.planetapp.ui.theme.components.BottomNavigationBar
import com.example.planetapp.ui.theme.screens.DetailsScreen
import com.example.planetapp.ui.theme.screens.FavoritesScreen
import com.example.planetapp.ui.theme.screens.HomeScreen

sealed class BottomBarScreen(val route: String, val label: String, val icon: @Composable () -> Unit) {
    object Home : BottomBarScreen("home", "Home", { Icon(Icons.Default.Home, contentDescription = null) })
    object Favorites : BottomBarScreen("favorites", "Favoritos", { Icon(Icons.Default.Favorite, contentDescription = null) })
}

@ExperimentalMaterial3Api
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(BottomBarScreen.Home.route) {
                HomeScreen(
                    onPlanetSelected = { planet ->
                        navController.navigate("details/${planet.name}")
                    },
                    onSettingsClick = onSettingsClick,
                    onHelpClick = onHelpClick
                )
            }
            composable(BottomBarScreen.Favorites.route) {
                FavoritesScreen(
                    onPlanetSelected = { planet ->
                        navController.navigate("details/${planet.name}")
                    }
                )
            }
            composable("details/{planetName}") { backStackEntry ->
                val planetName = backStackEntry.arguments?.getString("planetName")
                val selectedPlanet = planetList.firstOrNull { it.name == planetName }
                selectedPlanet?.let { DetailsScreen(it) }
            }
        }
    }
}
