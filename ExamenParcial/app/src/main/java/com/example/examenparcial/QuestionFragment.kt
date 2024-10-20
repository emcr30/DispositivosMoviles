//Question Fragment
// Evelyn Milagros Chipana Ramos
// Creación: 18-10-2024
// Finalización: 19-10-2024
package com.example.examenparcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class QuestionFragment : Fragment() {

    private var currentQuestionIndex = 0
    private var questionList: ArrayList<Question>? = null
    private var selectedOption: Int = -1

    private lateinit var questionTextView: TextView
    private lateinit var questionImageView: ImageView
    private lateinit var radioGroup: RadioGroup
    private lateinit var progressBar: ProgressBar
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        questionList = Constants.getQuestion()

        questionTextView = view.findViewById(R.id.question_text)
        questionImageView = view.findViewById(R.id.question_image)
        radioGroup = view.findViewById(R.id.options_group)
        progressBar = view.findViewById(R.id.progressBar)
        submitButton = view.findViewById(R.id.submit_button)

        progressBar.max = questionList?.size ?: 1

        showQuestion()

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            selectedOption = when (checkedId) {
                R.id.option_one -> 1
                R.id.option_two -> 2
                R.id.option_three -> 3
                R.id.option_four -> 4
                else -> -1
            }
        }

        submitButton.setOnClickListener {
            if (selectedOption != -1) {
                // Verificar si la opción seleccionada es la correcta
                val currentQuestion = questionList!![currentQuestionIndex]
                val isCorrect = selectedOption == currentQuestion.correctOption

                // Crear un bundle para pasar el resultado a AnswerFragment
                val bundle = Bundle()
                bundle.putBoolean("isAnswerCorrect", isCorrect)

                // Navegar a AnswerFragment con el bundle
                findNavController().navigate(R.id.action_questionFragment_to_answerFragment, bundle)
            } else {
                Toast.makeText(requireContext(), "Selecciona una opción", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun showQuestion() {
        val currentQuestion = questionList!![currentQuestionIndex]

        questionTextView.text = currentQuestion.question

        if (currentQuestion.image != 0) {
            questionImageView.setImageResource(currentQuestion.image)
            questionImageView.visibility = View.VISIBLE
        } else {
            questionImageView.visibility = View.GONE
        }

        radioGroup.clearCheck()
        view?.findViewById<RadioButton>(R.id.option_one)?.text = currentQuestion.option1
        view?.findViewById<RadioButton>(R.id.option_two)?.text = currentQuestion.option2
        view?.findViewById<RadioButton>(R.id.option_three)?.text = currentQuestion.option3
        view?.findViewById<RadioButton>(R.id.option_four)?.text = currentQuestion.option4

        progressBar.progress = currentQuestionIndex + 1
    }
}
