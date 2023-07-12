package com.mamani.xavier.tecmedia.publication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.mamani.xavier.tecmedia.R
import com.mamani.xavier.tecmedia.databinding.ActivityDetallesPublicacionBinding
import com.mamani.xavier.tecmedia.mapa.MainActivity
import com.mamani.xavier.tecmedia.publication.Api.PublicacionX
import com.mamani.xavier.tecmedia.publication.favoritos.FavoritosActivity
import com.mamani.xavier.tecmedia.publication.favoritos.FavoritosManager

class DetallesPublicacionActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PUBLICACION = "publicacion"
    }

    lateinit var binding: ActivityDetallesPublicacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesPublicacionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationView() // Configurar el BottomNavigationView

        val publicacionJson = intent.getStringExtra(EXTRA_PUBLICACION)
        val gson = Gson()
        val publicacion = gson.fromJson(publicacionJson, PublicacionX::class.java)

        // Mostrar los detalles del publicacion en la interfaz de usuario
        binding.tvCategoria.text = publicacion.categoria
        binding.tvTitulo.text = publicacion.titulo
        binding.tvContenido.text = publicacion.contenido
        binding.tvUrl.text = publicacion.url
        binding.tvEmail.text = publicacion.email


        // Configurar el OnClickListener del botón
        binding.btnAgregarFavoritos.setOnClickListener {
            val publicacion = gson.fromJson(publicacionJson, PublicacionX::class.java)
            FavoritosManager.agregarPublicacion(publicacion)
            Toast.makeText(this, "Agregado a favoritos", Toast.LENGTH_SHORT).show()
        }


    }
    private fun setupBottomNavigationView() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_inicio -> {
                    startActivity(Intent(this, MainActivity::class.java))// Acción para el elemento "Mapa"
                    true
                }
                R.id.action_publicacions -> {
                    startActivity(Intent(this, MainActivityRes::class.java))// Acción para el elemento "Publicacions"
                    true
                }
                R.id.action_favoritos -> {
                    startActivity(Intent(this, FavoritosActivity::class.java))// Acción para el elemento "Favoritos"
                    true
                }
                else -> false
            }
        }
    }

    private fun getImageResource(publicacionId: Int): Int {
        val nombreImagen = "publicacion${publicacionId % 5 + 1}"
        return resources.getIdentifier(nombreImagen, "drawable", packageName)
    }
}
