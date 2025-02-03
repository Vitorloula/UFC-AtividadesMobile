package com.example.investidorapp.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.AndroidViewModel
import com.example.investidorapp.MainActivity
import com.example.investidorapp.R
import com.example.investidorapp.model.Investimento
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InvestimentoViewModel(application: Application) : AndroidViewModel(application) {

    private val database = FirebaseDatabase.getInstance()
        .reference.child("investimentos")

    private val _investimentos = MutableStateFlow<List<Investimento>>(emptyList())
    val investimentos: StateFlow<List<Investimento>> = _investimentos

    init {
        criarCanalNotificacoes()
        monitorarAlteracoes()
        carregarInvestimentos()
    }

    private fun criarCanalNotificacoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "investimentos_notifications",
                "Notificações de Investimentos",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notificações sobre alterações em investimentos"
            }

            val notificationManager = getApplication<Application>()
                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun monitorarAlteracoes() {
        database.addChildEventListener(object : ChildEventListener {
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                tratarAlteracaoInvestimento(snapshot)
                carregarInvestimentos()
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                carregarInvestimentos()
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                carregarInvestimentos()
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseError", "Erro ao monitorar alterações: ${error.message}")
            }
        })
    }

    private fun tratarAlteracaoInvestimento(snapshot: DataSnapshot) {
        val nome = snapshot.key ?: "Desconhecido"
        val valor = snapshot.getValue(Int::class.java) ?: 0

        Log.d("InvestimentoUpdate", "Investimento atualizado: $nome - R$$valor")
        enviarNotificacao("Investimento Atualizado", "$nome - R$$valor")
    }

    fun carregarInvestimentos() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val novaLista = mutableListOf<Investimento>()

                snapshot.children.forEach { item ->
                    val nome = item.key ?: "Desconhecido"
                    val valor = item.getValue(Int::class.java) ?: 0

                    Log.d("FirebaseData", "Carregando: $nome - R$$valor")
                    novaLista.add(Investimento(nome, valor))
                }

                _investimentos.value = novaLista
                Log.i("Investimentos", "Lista atualizada: ${novaLista.size} itens")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseError", "Erro ao carregar investimentos: ${error.message}")
            }
        })
    }

    @SuppressLint("MissingPermission")
    private fun enviarNotificacao(titulo: String, mensagem: String) {
        val notificationId = System.currentTimeMillis().toInt()
        val intent = Intent(getApplication(), MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            getApplication(),
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(getApplication(), "investimentos_notifications")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(titulo)
            .setContentText(mensagem)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(getApplication()).notify(notificationId, notification)
    }

    fun adicionarInvestimento(nome: String, valor: Int) {
        database.child(nome).setValue(valor)
            .addOnSuccessListener {
                Log.d("Firebase", "Investimento $nome adicionado com sucesso")
            }
            .addOnFailureListener { e ->
                Log.e("Firebase", "Erro ao adicionar investimento", e)
            }
    }

    fun removerInvestimento(nome: String) {
        database.child(nome).removeValue()
            .addOnSuccessListener {
                Log.d("Firebase", "Investimento $nome removido com sucesso")
            }
            .addOnFailureListener { e ->
                Log.e("Firebase", "Erro ao remover investimento", e)
            }
    }
}