// Implementación de fragments en un reproductor de musica
// Evelyn Milagros Chipana Ramos
// Creación: 22-09-2024
// Finalización: 29-09-2024

package com.example.fragreproduccionmusica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(), AudioSelectionFragment.OnAudioSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fragmento de selección de audio
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, AudioSelectionFragment().apply {
                    setOnAudioSelectedListener(this@MainActivity)
                })
            }.commit()
        }
    }

    override fun onAudioSelected(audioName: String) {
        // reproductor de audio con el audio seleccionado
        val audioPlayerFragment = AudioPlayerFragment().apply {
            arguments = Bundle().apply {
                putString("audio_name", audioName)
            }
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, audioPlayerFragment)
            addToBackStack(null) // regresar al fragmento anterior
        }.commit()

    }
}
