package com.example.atividade7.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.atividade7.models.PilotF1

@ExperimentalMaterial3Api
@Composable
fun PilotScreen(pilot: PilotF1) {
    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = pilot.nome) })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Image(
                painter = painterResource(id = pilot.imageRes),
                contentDescription = pilot.nome,
                modifier = Modifier.clip(CircleShape)
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = pilot.descricao)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = pilot.curiosidades)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = pilot.equipe)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "ID: ${pilot.id}")
        }

    }
}