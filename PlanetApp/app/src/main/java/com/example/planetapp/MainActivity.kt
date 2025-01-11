package com.example.planetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planetapp.navigation.NavGraph
import com.example.planetapp.ui.theme.PlanetAppTheme
import androidx.compose.material3.ExperimentalMaterial3Api


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetAppTheme {
                NavGraph(
                    onSettingsClick = { println("Configurações clicadas") },
                    onHelpClick = { println("Ajuda clicada") }
                )
            }
        }
    }
}
