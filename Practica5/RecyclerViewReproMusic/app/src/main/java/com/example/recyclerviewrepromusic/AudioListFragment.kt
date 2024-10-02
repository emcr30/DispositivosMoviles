// Fragment para la lista de audios
// Evelyn Milagros Chipana Ramos
// Creación: 01-10-2024
// Finalización: 01-10-2024

package com.example.recyclerviewrepromusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AudioListFragment : Fragment() {

    // lista de audios que se mostrará en el RecyclerView
    private val audioList = listOf(
        Audio("Audio 1", R.drawable.audio1_image, R.raw.audio1, "3:38"),
        Audio("Audio 2", R.drawable.audio2_image, R.raw.audio2, "3:45"),
        Audio("Audio 3", R.drawable.audio3_image, R.raw.audio3, "4:41"),
        Audio("Audio 4", R.drawable.audio4_image, R.raw.audio4, "3:35"),
        Audio("Audio 5", R.drawable.audio5_image, R.raw.audio5, "3:28")
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflar el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_audio_list, container, false)

        // configuración del RecyclerView y layout manager
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext()) // disposición vertical

        // crear el adaptador y manejar el click en un audio
        val adapter = AudioAdapter(audioList) { audio ->
            // instanciar el fragmento de reproducción y pasarle los datos del audio seleccionado
            val fragment = AudioPlayerFragment().apply {
                arguments = Bundle().apply {
                    putString("audioName", audio.name) // pasar el nombre del audio
                    putInt("audioResId", audio.audioResId) // pasar el recurso de audio
                    putInt("audioImage", audio.imageResId) // pasar la imagen del audio
                }
            }
            // reemplazar el fragmento actual con el fragmento del reproductor
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit() // realizar la transacción
        }
        recyclerView.adapter = adapter // asignar el adaptador al RecyclerView

        return view
    }
