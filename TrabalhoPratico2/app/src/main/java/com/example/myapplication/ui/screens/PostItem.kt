package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.models.Post
import com.example.myapplication.ui.theme.Red40
import com.example.myapplication.ui.theme.RedMint80

@Composable
fun PostItem(post: Post, onDelete: (Int)-> Unit, onEdit: (Post)-> Unit){
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Título:",
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
                Text(text = post.title, style = MaterialTheme.typography.h6)
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Conteúdo:",
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
                Text(text = post.content, style = MaterialTheme.typography.body2)
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { showDialog = true },
                    colors = ButtonDefaults.buttonColors(RedMint80),
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Text(text = "Deletar")
                }
                Button(
                    onClick = { onEdit(post) },
                    colors = ButtonDefaults.buttonColors(Red40),
                ) {
                    Text(text = "Editar")
                }
            }
        }

    }

    if(showDialog){
        AlertDialog(
            onDismissRequest = {showDialog = false},
            title = {Text(text = "Confirmar Exclusão")},
            text = { Text(text = "Tem certeza que deseja deletar este post ?")},
            confirmButton = {
                TextButton(
                    onClick = {onDelete(post.id)
                        showDialog = false })
                {
                    Text(text = "Sim")
                }
            },
            dismissButton = {
                TextButton(onClick ={ showDialog = false}) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}