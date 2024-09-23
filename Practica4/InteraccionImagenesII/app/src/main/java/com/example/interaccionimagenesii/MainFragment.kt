//Implementación de un spinner para la elección de imágenes con fragments


package com.example.interaccionimagenesii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment


class MainFragment : Fragment() {

    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // inicializar el spinner y el botón
        imageSpinner = view.findViewById(R.id.image_spinner)
        nextButton = view.findViewById(R.id.next_button)

        // configurar el Spinner
        val images = arrayOf("Imagen 1", "Imagen 2", "Imagen 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, images)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imageSpinner.adapter = adapter

        // configurar el botón siguiente
        nextButton.setOnClickListener {
            val selectedPosition = imageSpinner.selectedItemPosition
            val fragment = ImageFragment.newInstance(selectedPosition)
            // cambiar al fragmento de imagen
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selected_position", imageSpinner.selectedItemPosition)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val selectedPosition = savedInstanceState?.getInt("selected_position")
        selectedPosition?.let { imageSpinner.setSelection(it) }
    }
}
