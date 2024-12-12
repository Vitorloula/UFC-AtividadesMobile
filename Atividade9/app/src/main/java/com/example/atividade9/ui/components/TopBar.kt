package com.example.atividade9.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@ExperimentalMaterial3Api
@Composable

fun TopBar (
    onThemeToggle: () -> Unit,
    onOpenDrawer: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Event App") },
        navigationIcon = {
            IconButton(onClick = { onOpenDrawer() }) {
                Icon(Icons.Default.Menu, contentDescription = "Open Menu")
            }
        },
        actions = {
            IconButton(onClick = { onThemeToggle() }) {
                Icon(Icons.Default.Menu, contentDescription = "Toggle Theme")
            }
        }
    )
}