package com.example.atividade7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.atividade7.navigation.NavGraph
import com.example.atividade7.ui.theme.Atividade7Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Atividade7Theme {
                // A surface container using the 'background' color from the theme
                NavGraph()
            }
        }
    }
}