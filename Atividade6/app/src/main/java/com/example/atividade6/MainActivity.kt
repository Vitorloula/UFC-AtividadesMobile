package com.example.atividade6

import android.net.Uri
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.atividade6.ui.theme.Atividade6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Atividade6Theme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable(
                        "animal/{animal}",
                        arguments = listOf(navArgument("animal") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val animal = backStackEntry.arguments?.getString("animal") ?: "Dog"
                        AnimalScreen(animal, navController)
                    }
                    composable(
                        "video/{animal}",
                        arguments = listOf(navArgument("animal") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val animal = backStackEntry.arguments?.getString("animal") ?: "Dog"
                        VideoPlayerScreen(animal)
                    }
                    composable(
                        "hino/{animal}",
                        arguments = listOf(navArgument("animal") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val animal = backStackEntry.arguments?.getString("animal") ?: "Mascote Bahia"
                        HinoPlayerScreen(animal)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var selectedAnimal by remember { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu de Mascotes") },
                actions = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Mascote Bahia") },
                            onClick = {
                                selectedAnimal = "Mascote Bahia"
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Ceará") },
                            onClick = {
                                selectedAnimal = "Ceará"
                                expanded = false
                            }
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            selectedAnimal?.let { animal ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = if (animal == "Mascote Bahia") R.drawable.mascote_esporte_clube_bahia else R.drawable.mascote_ceara),
                        contentDescription = animal,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(200.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { navController.navigate("animal/$animal") }) {
                        Text("Ver Detalhes")
                    }
                }
            } ?: Text("Selecione um Mascote no Menu")
        }
    }
}

@Composable
fun AnimalScreen(animal: String, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Tela do $animal", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("video/$animal") }) {
            Text("Assistir Vídeo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("hino/$animal") }) {
            Text("Escutar Hino")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar")
        }
    }
}

@Composable
fun VideoPlayerScreen(animal: String) {
    AndroidView(factory = { context ->
        VideoView(context).apply {
            val videoRes = if (animal == "Mascote Bahia") R.raw.ssstik_ecbahia else R.raw.ssstikio_ceara
            setVideoURI(Uri.parse("android.resource://${context.packageName}/$videoRes"))
            start()
        }
    }, modifier = Modifier.fillMaxSize())
}

@Composable
fun HinoPlayerScreen(animal: String) {
    val context = LocalContext.current
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var isPlaying by remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release() // Libera recursos ao sair da tela
        }
    }

    val audioResId = if (animal == "Mascote Bahia") R.raw.hino_ec_bahia else R.raw.hino_ceara_sporting_club
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (isPlaying) {
                    mediaPlayer?.stop()
                    mediaPlayer?.release()
                    mediaPlayer = null
                    isPlaying = false
                } else {
                    mediaPlayer = MediaPlayer.create(context, audioResId).apply {
                        start()
                        setOnCompletionListener {
                            isPlaying = false // Atualiza o estado após o término
                        }
                    }
                    isPlaying = true
                }
            }
        ) {
            Text(if (isPlaying) "Parar Reprodução" else "Reproduzir Hino")
        }
    }
}