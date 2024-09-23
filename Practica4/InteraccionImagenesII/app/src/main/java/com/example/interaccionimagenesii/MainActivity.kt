// Implementación de un spinner para la elección de imágenes con fragments
// Evelyn Milagros Chipana Ramos
// Creación: 22-09-2024
// Finalización: 22-09-2024

package com.example.interaccionimagenesii

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // cargar el MainFragment si no existe
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment())
                .commit()
        }
    }
}

