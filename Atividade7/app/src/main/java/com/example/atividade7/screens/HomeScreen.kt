package com.example.atividade7.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atividade7.models.PilotF1
import com.example.atividade7.models.pilotF1
import com.example.atividade7.screens.components.PilotListItem

@Composable
fun HomeScreen(onPilotSelected: (PilotF1) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredPilots = pilotF1.filter { pilot ->
        pilot.nome.contains(searchQuery, ignoreCase = true)
    }
    Column{
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search") }
        )
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(filteredPilots) { pilot ->
                PilotListItem(pilot = pilot, onPilotSelected = onPilotSelected)
            }
        }
    }
}