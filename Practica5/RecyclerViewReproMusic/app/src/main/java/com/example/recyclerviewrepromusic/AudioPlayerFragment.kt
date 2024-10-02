// Fragment para la reproduccion de audio
// Evelyn Milagros Chipana Ramos
// Creación: 01-10-2024
// Finalización: 01-10-2024
package com.example.recyclerviewrepromusic


import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class AudioPlayerFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null // variable para manejar el reproductor de audio

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflar el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_audio_player, container, false)

        // obtener los argumentos del fragmento anterior
        val audioName = arguments?.getString("audioName") // nombre del audio
        val audioResId = arguments?.getInt("audioResId") // recurso de audio
        val audioImage = arguments?.getInt("audioImage") // imagen del audio

        // inicializar vistas del fragmento
        val audioTextView = view.findViewById<TextView>(R.id.audioName)
        val audioImageView = view.findViewById<ImageView>(R.id.audioImage)
        val btnPlay = view.findViewById<Button>(R.id.btnPlay)
        val btnPause = view.findViewById<Button>(R.id.btnPause)
        val btnStop = view.findViewById<Button>(R.id.btnStop)

        audioTextView.text = audioName // establecer el nombre del audio
        audioImageView.setImageResource(audioImage ?: R.drawable.ic_launcher_foreground) // establecer la imagen del audio

        mediaPlayer = MediaPlayer.create(requireContext(), audioResId!!) // crear el MediaPlayer con el recurso de audio

        // configurar el botón de reproducción
        btnPlay.setOnClickListener {
            mediaPlayer?.start() // iniciar la reproducción
        }

        // configurar el botón de pausa
        btnPause.setOnClickListener {
            mediaPlayer?.pause() // pausar la reproducción
        }

        // configurar el botón de detener
        btnStop.setOnClickListener {
            mediaPlayer?.stop() // detener la reproducción
            mediaPlayer?.prepare() // reiniciar el audio
        }

        return view // devolver la vista del fragmento
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release() // liberar recursos del MediaPlayer
        mediaPlayer = null // establecer mediaPlayer a null
    }
}
