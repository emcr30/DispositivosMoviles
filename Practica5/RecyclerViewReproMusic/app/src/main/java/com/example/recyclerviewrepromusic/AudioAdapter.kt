// Clase AudioAdapter, para el adaptador del RecyclerView
// Evelyn Milagros Chipana Ramos
// Creación: 01-10-2024
// Finalización: 01-10-2024

package com.example.recyclerviewrepromusic


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AudioAdapter(
    private val audioList: List<Audio>, // lista de audios que se mostrará
    private val onAudioClick: (Audio) -> Unit // función lambda que maneja el click en un audio
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    // viewHolder para almacenar y reciclar vistas de los ítems del recyclerView
    inner class AudioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val audioName: TextView = itemView.findViewById(R.id.audioName) // nombre del audio
        val audioImage: ImageView = itemView.findViewById(R.id.audioImage) // imagen del audio
        val audioDuration: TextView = itemView.findViewById(R.id.audioDuration) // duración del audio
    }

    // inflar el layout del ítem y crear un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio, parent, false)
        return AudioViewHolder(view)
    }

    // enlaza los datos del audio con las vistas del ViewHolder
    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audio = audioList[position]
        holder.audioName.text = audio.name // asignar el nombre del audio
        holder.audioImage.setImageResource(audio.imageResId) // asignar la imagen del audio
        holder.audioDuration.text = audio.duration // asignar la duración del audio

        holder.itemView.setOnClickListener {
            onAudioClick(audio) // manejar el click sobre el ítem
        }
    }

    // devuelve la cantidad total de ítems en la lista
    override fun getItemCount(): Int = audioList.size
}