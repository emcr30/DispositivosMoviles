package com.example.fragreproduccionmusica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

        // Configura el adapter del spinner
        val audioNames = arrayOf("I Can Do It With a Broken Heart", "imgonnagetyouback", "loml", "Fresh Out The Slammer", "My Boy Only Breaks His Favorite Toys")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, audioNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

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
