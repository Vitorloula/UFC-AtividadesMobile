package com.example.atividade7.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.atividade7.models.pilotF1
import com.example.atividade7.screens.HomeScreen
import com.example.atividade7.screens.PilotScreen

@ExperimentalMaterial3Api
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onPilotSelected = { pilot ->
                navController.navigate("pilot/${pilot.id}")
            })
        }
        composable("pilot/{pilot}") { backStackEntry ->
            val pilotId = backStackEntry.arguments?.getString("pilot")?.toIntOrNull()
            if (pilotId != null)
                pilotF1.find { it.id == pilotId }?.let { PilotScreen(pilot = it) }
        }
    }

}