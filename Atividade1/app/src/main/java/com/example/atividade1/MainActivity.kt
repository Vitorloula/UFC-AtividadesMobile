package com.example.atividade1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "onCreate() chamado")
        Toast.makeText(this, "onCreate() chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart() chamado")
        Toast.makeText(this, "onStart() chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume() chamado")
        Toast.makeText(this, "onResume() chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause() chamado")
        Toast.makeText(this, "onPause() chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop() chamado")
        Toast.makeText(this, "onStop() chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart() chamado")
        Toast.makeText(this, "onRestart() chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy() chamado")
        Toast.makeText(this, "onDestroy() chamado", Toast.LENGTH_SHORT).show()
    }
}
