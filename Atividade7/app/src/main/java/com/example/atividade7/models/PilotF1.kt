package com.example.atividade7.models

import com.example.atividade7.R

data class PilotF1 (
    val id: Int,
    val nome: String,
    val equipe: String,
    val imageRes: Int,
    val descricao: String,
    val curiosidades: String,
    val isFavorite: Boolean
)

val pilotF1 = listOf(
    PilotF1(
        id = 1,
        nome = "Lewis Hamilton",
        equipe = "Mercedes",
        imageRes = R.drawable.lewishamilton,
        descricao = "Sete vezes campeão mundial de Fórmula 1, conhecido por sua habilidade excepcional e ativismo fora das pistas.",
        curiosidades = "Lewis Hamilton é o piloto com mais poles positions na história da F1.",
        isFavorite = false
    ),
    PilotF1(
        id = 2,
        nome = "Max Verstappen",
        equipe = "Red Bull Racing",
        imageRes = R.drawable.maxverstappen,
        descricao = "Campeão mundial de Fórmula 1, famoso por seu estilo de pilotagem agressivo e determinação.",
        curiosidades = "Max Verstappen é o piloto mais jovem a vencer uma corrida de F1, aos 18 anos.",
        isFavorite = false
    ),
    PilotF1(
        id = 3,
        nome = "Charles Leclerc",
        equipe = "Ferrari",
        imageRes = R.drawable.charlesleclerc,
        descricao = "Jovem talento da Ferrari, conhecido por sua velocidade e habilidade em qualificação.",
        curiosidades = "Charles Leclerc é o primeiro piloto monegasco a vencer uma corrida de F1.",
        isFavorite = false
    ),
    PilotF1(
        id = 4,
        nome = "Sebastian Vettel",
        equipe = "Aston Martin",
        imageRes = R.drawable.vettel,
        descricao = "Quatro vezes campeão mundial de Fórmula 1, respeitado por sua experiência e conhecimento técnico.",
        curiosidades = "Sebastian Vettel é o piloto mais jovem a ganhar um campeonato mundial de F1.",
        isFavorite = false
    ),
    PilotF1(
        id = 5,
        nome = "Fernando Alonso",
        equipe = "Alpine",
        imageRes = R.drawable.alonso,
        descricao = "Bicampeão mundial de Fórmula 1, reconhecido por sua versatilidade e longevidade na carreira.",
        curiosidades = "Fernando Alonso é o único piloto espanhol a vencer um campeonato mundial de F1.",
        isFavorite = false
    )
)