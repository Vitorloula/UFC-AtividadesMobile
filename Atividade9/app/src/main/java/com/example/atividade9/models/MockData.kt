package com.example.atividade9.models

import androidx.compose.runtime.mutableStateOf
import com.example.atividade9.R

val eventList = listOf(
    Event(
        id = 1,
        title = "Plantão Fertival",
        description = "Plantão Fortaleza é um evento cultural e musical que promete agitar a cena urbana da capital cearense. Com foco na união de ritmos contemporâneos, o evento reúne os melhores nomes do trap, rap e funk, oferecendo uma experiência única para os amantes da música e da cultura de rua.\n",
        date = "20/12/2025",
        location = "Fortaleza CE",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.event1
    ),
    Event(
        id = 2,
        title = "UFC - Luta Principal",
        description = "A luta principal do UFC é o ápice de cada evento, trazendo os maiores nomes do MMA mundial para um confronto épico que atrai milhões de espectadores ao redor do planeta. Seja uma disputa de cinturão, um confronto entre veteranos ou uma revanche aguardada, a luta principal é cuidadosamente selecionada para garantir máxima emoção e relevância esportiva.\n",
        date = "21/05/2025",
        location = "Fortaleza CE",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.ufc
    ),

    Event(
        id = 3,
        title = "DK King Drift",
        description = "O DK King Drift é um evento imperdível para os amantes do automobilismo. Reunindo pilotos habilidosos e carros preparados, o evento traz manobras radicais, velocidade e muita adrenalina em uma celebração única da cultura drift.",
        date = "20/12/2025",
        location = "Fortaleza CE",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.drift
    ),

    Event(
        id = 4,
        title = "NBB Fortaleza",
        description = "O NBB Fortaleza celebra o melhor do basquete nacional em uma disputa acirrada entre grandes equipes. O evento reúne fãs do esporte e proporciona uma experiência emocionante com jogos de alto nível e atmosfera vibrante.",
        date = "20/12/2025",
        location = "Fortaleza CE",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.basquete
    )

    )

