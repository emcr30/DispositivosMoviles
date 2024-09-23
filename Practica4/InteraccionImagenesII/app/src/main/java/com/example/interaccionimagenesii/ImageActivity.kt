package com.example.interaccionimagenesii

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageView = findViewById(R.id.image_view)
        backButton = findViewById(R.id.back_button)

        // Obtener la imagen seleccionada
        val selectedImage = intent.getIntExtra("selected_image", 0)
        when (selectedImage) {
            0 -> imageView.setImageResource(R.drawable.image1)
            1 -> imageView.setImageResource(R.drawable.image2)
            2 -> imageView.setImageResource(R.drawable.image3)
        }

        // Manejar el botón "Volver"
        backButton.setOnClickListener {
            finish()
        }
    }
}


