package com.example.planetapp.models

import com.example.planetapp.R

data class Planet(
    val id: Int,
    val name: String,
    val type: String,
    val galaxy: String,
    val distanceFromSun: String,
    val diameter: String,
    val characteristics: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)

val planetList = listOf(
    Planet(1, "Terra", "Terrestre", "Via Láctea", "149,6 milhões de km", "12.742 km", "Suporta vida, possui água e atmosfera.", R.drawable.terra),
    Planet(2, "Marte", "Terrestre", "Via Láctea", "227,9 milhões de km", "6.779 km", "Conhecido como Planeta Vermelho, possui o maior vulcão do sistema solar.", R.drawable.marte),
    Planet(3, "Júpiter", "Gigante Gasoso", "Via Láctea", "778,5 milhões de km", "139.820 km", "Maior planeta do sistema solar, com a Grande Mancha Vermelha.", R.drawable.jupiter),
    Planet(4, "Saturno", "Gigante Gasoso", "Via Láctea", "1,43 bilhões de km", "116.460 km", "Famoso por seu extenso sistema de anéis.", R.drawable.saturno),
    Planet(5, "Vênus", "Terrestre", "Via Láctea", "108,2 milhões de km", "12.104 km", "O planeta mais quente do sistema solar devido à sua atmosfera densa.", R.drawable.venus),
    Planet(6, "Netuno", "Gigante de Gelo", "Via Láctea", "4,5 bilhões de km", "49.244 km", "Conhecido por sua cor azul intensa e tempestades violentas.", R.drawable.netuno),
    Planet(7, "Mercúrio", "Terrestre", "Via Láctea", "57,9 milhões de km", "4.880 km", "Planeta mais próximo do Sol, sem atmosfera.", R.drawable.mercurio),
    Planet(8, "Urano", "Gigante de Gelo", "Via Láctea", "2,87 bilhões de km", "50.724 km", "Roda de lado, com cor azul-verde pálida.", R.drawable.urano)
)
