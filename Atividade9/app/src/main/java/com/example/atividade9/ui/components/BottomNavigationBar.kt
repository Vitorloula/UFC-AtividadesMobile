package com.example.atividade9.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val items = listOf(
            Triple ("Home", "Home", Icons.Default.Home),
            Triple ("Events", "Events", Icons.Default.DateRange),
            Triple ("Favorites", "Favorites", Icons.Default.Favorite),
        )
        items.forEach {(route, label, icon)->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = navController.currentBackStackEntryAsState().value?.destination?.route == route,
                onClick = { navController.navigate(route) }
            )
        }
    }
}