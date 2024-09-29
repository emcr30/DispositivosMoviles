package com.example.fragreproduccionmusica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment


class AudioSelectionFragment : Fragment() {


    private lateinit var listener: OnAudioSelectedListener


    interface OnAudioSelectedListener {
        fun onAudioSelected(audioName: String)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio_selection, container, false)


        val spinner = view.findViewById<Spinner>(R.id.spinnerAudio)
        val buttonSelect = view.findViewById<Button>(R.id.buttonSelect)


        buttonSelect.setOnClickListener {
            val selectedAudio = spinner.selectedItem.toString()
            listener.onAudioSelected(selectedAudio)
        }


        return view
    }


    fun setOnAudioSelectedListener(listener: OnAudioSelectedListener) {
        this.listener = listener
    }
}
