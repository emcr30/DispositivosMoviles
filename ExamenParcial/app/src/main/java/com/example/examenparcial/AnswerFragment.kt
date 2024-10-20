// Answer Fragment
// Evelyn Milagros Chipana Ramos
// Creación: 18-10-2024
// Finalización: 19-10-2024
package com.example.examenparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class AnswerFragment : Fragment() {

    // recibir argumentos
    private var isAnswerCorrect: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // obtener el TextView y Button desde el layout
        val answerTextView: TextView = view.findViewById(R.id.tvAnswerResult)
        val goBackButton: Button = view.findViewById(R.id.btnGoBack)

        // recuperar el argumento enviado desde el QuestionFragment
        arguments?.let {
            isAnswerCorrect = it.getBoolean("isAnswerCorrect", false)
        }

        // mostrar mensaje dependiendo de si la respuesta es correcta o no
        if (isAnswerCorrect) {
            answerTextView.text = "¡Respuesta Correcta!"
        } else {
            answerTextView.text = "Respuesta Incorrecta. ¡Intenta de nuevo!"
        }

        // botón para regresar al WelcomeFragment
        goBackButton.setOnClickListener {
            // navegar al inicio
            findNavController().navigate(R.id.action_answerFragment_to_welcomeFragment)
        }
    }
}