package com.example.msgapp2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Cores Personalizadas
val BluePrimary = Color(0xFF2196F3) // Azul vibrante
val TealSecondary = Color(0xFF4DB6AC) // Verde-água
val OrangeTertiary = Color(0xFFFFB74D) // Laranja suave
val LightGray = Color(0xFFF5F5F5) // Cinza claro
val ErrorRed = Color(0xFFB00020) // Vermelho para erros

// Tema Claro
private val LightColors = lightColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    secondary = TealSecondary,
    onSecondary = Color.White,
    tertiary = OrangeTertiary,
    onTertiary = Color.Black,
    surface = LightGray,
    onSurface = Color.Black,
    background = LightGray,
    onBackground = Color.Black,
    error = ErrorRed,
    onError = Color.White
)

@Composable
fun MsgApp2Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}