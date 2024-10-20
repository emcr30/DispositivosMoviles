package com.example.examenparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import android.widget.Button

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // botón para empezar el juego
        val startButton: Button = view.findViewById(R.id.start_button)
        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment)
        }
    }
}
