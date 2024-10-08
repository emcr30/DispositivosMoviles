// Reproduccion de musica con imagenes y botones, en este caso veremos el album Reptutation de Taylor Swift
// Evelyn Milagros Chipana Ramos
// Creación: 15-09-2024
// Finalización: 19-09-2024

package com.example.reproduccionmusica;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.reproduccionmusica.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinner_audios)
        val btnSelect: Button = findViewById(R.id.btn_select)
        //audios
        val audios = arrayOf("...Ready for it?", "End Game", "I Did Something Bad", "Don't Blame Me", "Delicate")

        // adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, audios)
        spinner.adapter = adapter

        btnSelect.setOnClickListener {
            val selectedAudio = spinner.selectedItem.toString()
            // cambiar a MusicPlayerActivity
            val intent = Intent(this, MusicPlayerActivity::class.java).apply {
                putExtra("AUDIO_NAME", selectedAudio)
            }
            startActivity(intent)
        }
    }
}
