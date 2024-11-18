package com.example.atividade4

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val nameTextView = findViewById<TextView>(R.id.name)
        val descriptionTextView = findViewById<TextView>(R.id.description)
        val currentJobTextView = findViewById<TextView>(R.id.current_job)
        val experienceLayout = findViewById<LinearLayout>(R.id.experience_list)

        nameTextView.text = "Vitor Loula Silva"
        descriptionTextView.text = "Desenvolvedor de Software apaixonado por tecnologias mobile e automobilismo."
        currentJobTextView.text = "Emprego Atual: Desenvolvedor de Software"

        profileImage.setImageResource(R.drawable.ic_launcher_foreground)

        val experiences = listOf(
            "Empresa XYZ - Desenvolvedor Jr. (2018-2020)",
            "Empresa ABC - Estagiário em Desenvolvimento (2017-2018)",
            "Startup DEF - Analista de Sistemas (2020-2022)"
        )

        for (experience in experiences) {
            addExperience(experienceLayout, experience)
        }

        profileImage.setOnClickListener {
            Toast.makeText(this, "Você clicou na foto de perfil!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addExperience(layout: LinearLayout, experience: String) {
        val experienceTextView = TextView(this)
        experienceTextView.text = experience
        experienceTextView.textSize = 16f
        experienceTextView.setTextColor(resources.getColor(R.color.black))
        experienceTextView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        experienceTextView.setPadding(0, 0, 0, 8)
        layout.addView(experienceTextView)
    }
}
