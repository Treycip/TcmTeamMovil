package com.mamani.xavier.tecmedia.publication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.mamani.xavier.tecmedia.R
import com.mamani.xavier.tecmedia.publication.Api.PublicacionX

class PublicacionAdapter(private val publicacions: List<PublicacionX>) :
    RecyclerView.Adapter<PublicacionAdapter.PublicacionViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_publicacion, parent, false)
        return PublicacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: PublicacionViewHolder, position: Int) {
        val publicacion = publicacions[position]
        holder.bind(publicacion)

// Obtiene el índice correspondiente en el array de imágenes


        // Establece la imagen en el ImageView


        holder.itemView.setOnClickListener {
            val gson = Gson()
            val publicacionJson = gson.toJson(publicacion)

            val intent = Intent(holder.itemView.context, DetallesPublicacionActivity::class.java)
            intent.putExtra(DetallesPublicacionActivity.EXTRA_PUBLICACION, publicacionJson)
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return publicacions.size
    }

    inner class PublicacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        private val tvCategoria: TextView = itemView.findViewById(R.id.tvCategoria)
        private val tvFecha_pub: TextView = itemView.findViewById(R.id.tvFecha_pub)

        fun bind(publicacion: PublicacionX) {
            tvTitulo.text = publicacion.titulo
            tvCategoria.text = publicacion.categoria
            tvFecha_pub.text = publicacion.fecha_pub
        }
    }

}
