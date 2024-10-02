// Activity principal
// Evelyn Milagros Chipana Ramos
// Creación: 01-10-2024
// Finalización: 01-10-2024

package com.example.recyclerviewrepromusic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AudioListFragment())
                .commit()
        }
    }
}
