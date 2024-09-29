package com.example.fragreproduccionmusica

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

    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false
    private var audioResId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio_player, container, false)

        val audioName = arguments?.getString("audio_name") ?: "Audio 1"
        val audioTextView = view.findViewById<TextView>(R.id.audioName)
        audioTextView.text = audioName

        // cargar la imagen
        val audioImageView: ImageView = view.findViewById(R.id.audioImage)
        audioImageView.setImageResource(R.drawable.ttpd)

        audioResId = when (audioName) {
            "I Can Do It With a Broken Heart" -> R.raw.audio1
            "imgonnagetyouback" -> R.raw.audio2
            "loml" -> R.raw.audio3
            "Fresh Out The Slammer" -> R.raw.audio4
            "My Boy Only Breaks His Favorite Toys" -> R.raw.audio5
            else -> R.raw.audio1
        }

        mediaPlayer = MediaPlayer.create(requireContext(), audioResId)

        val buttonPlay = view.findViewById<Button>(R.id.buttonPlay)
        val buttonPause = view.findViewById<Button>(R.id.buttonPause)
        val buttonStop = view.findViewById<Button>(R.id.buttonStop)

        buttonPlay.setOnClickListener {
            if (!isPlaying) {
                mediaPlayer.start()
                isPlaying = true
            }
        }

        buttonPause.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
            }
        }

        buttonStop.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()
                isPlaying = false
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
