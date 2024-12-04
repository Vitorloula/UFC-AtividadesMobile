package com.example.atividade7.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.atividade7.models.PilotF1

@Composable

fun PilotListItem(pilot: PilotF1, onPilotSelected: (PilotF1) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row (
              verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = pilot.imageRes),
                    contentDescription = pilot.nome,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = pilot.nome)
                    Text(text = pilot.equipe)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = pilot.descricao)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = pilot.curiosidades)
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { onPilotSelected(pilot) }) {
                Text(text = "Detalhes")
            }
        }
    }
}


