package com.example.fragreproduccionmusica


import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        //audios seleccionados con su respectivo audio
        audioResId = when (audioName) {
            "Audio 1" -> R.raw.audio1
            "Audio 2" -> R.raw.audio2
            "Audio 3" -> R.raw.audio3
            "Audio 4" -> R.raw.audio4
            "Audio 5" -> R.raw.audio5
            else -> R.raw.audio1
        }


        mediaPlayer = MediaPlayer.create(requireContext(), audioResId)

        //botones
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
                mediaPlayer.prepare() // Reset media player to start again if needed
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
