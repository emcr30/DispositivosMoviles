package com.example.interaccionimagenesii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ImageFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var backButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image, container, false)

        imageView = view.findViewById(R.id.image_view)
        backButton = view.findViewById(R.id.back_button)

        // imagen seleccionada
        val selectedImage = arguments?.getInt("selected_image") ?: 0
        when (selectedImage) {
            0 -> imageView.setImageResource(R.drawable.image1)
            1 -> imageView.setImageResource(R.drawable.image2)
            2 -> imageView.setImageResource(R.drawable.image3)
        }

        // botón volver
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    companion object {
        fun newInstance(selectedImage: Int): ImageFragment {
            val fragment = ImageFragment()
            val args = Bundle()
            args.putInt("selected_image", selectedImage)
            fragment.arguments = args
            return fragment
        }
    }
}

