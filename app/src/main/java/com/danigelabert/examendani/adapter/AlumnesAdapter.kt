package com.danigelabert.examendani.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danigelabert.examendani.R
import com.danigelabert.examendani.model.Alumnes

class AlumnesAdapter(private val alumnes: List<Alumnes>, private val onItemClick: (Alumnes) -> Unit) :
    RecyclerView.Adapter<AlumnesAdapter.AlumnesViewHolder>() {

    // ViewHolder que contiene las vistas para cada elemento
    class AlumnesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.tvNom)
        val grup: TextView = view.findViewById(R.id.tvGrup)
        val nota: TextView = view.findViewById(R.id.tvNota)
    }

    // Crea una nueva vista (invocada por el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alumnes, parent, false) // Usa tu CardView aquí
        return AlumnesViewHolder(view)
    }

    // Reemplaza el contenido de una vista (invocada por el layout manager)
    override fun onBindViewHolder(holder: AlumnesViewHolder, position: Int) {
        val alumne = alumnes[position]

        holder.itemView.setOnClickListener {
            onItemClick.invoke(alumne)
        }

        holder.nom.text = alumne.nom
        holder.grup.text = alumne.grup
        holder.nota.text = alumne.nota.toString()
    }

    // Devuelve el tamaño de tu conjunto de datos (invocada por el layout manager)
    override fun getItemCount() = alumnes.size
}