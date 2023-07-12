package com.mamani.xavier.tecmedia.publication.favoritos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mamani.xavier.tecmedia.R
import com.mamani.xavier.tecmedia.databinding.ActivityFavoritosBinding
import com.mamani.xavier.tecmedia.mapa.MainActivity
import com.mamani.xavier.tecmedia.publication.MainActivityRes
import com.mamani.xavier.tecmedia.publication.PublicacionAdapter

class FavoritosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritosBinding
    private lateinit var favoritosAdapter: PublicacionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationView() // Configurar el BottomNavigationView

        // Obtén la lista de favoritos del FavoritosManager
        val favoritos = FavoritosManager.obtenerFavoritos()

        // Configura el adaptador con la lista de favoritos
        favoritosAdapter = PublicacionAdapter(favoritos)

        // Configura el LinearLayoutManager y el adaptador del RecyclerView
        binding.recyclerViewFavoritos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewFavoritos.adapter = favoritosAdapter

        // Configura el OnClickListener del botón "Limpiar Favoritos"
        binding.btnLimpiarFavoritos.setOnClickListener {
            FavoritosManager.limpiarFavoritos()
            favoritosAdapter.notifyDataSetChanged()


            Toast.makeText(this, "Se han limpiado los favoritos", Toast.LENGTH_SHORT).show()
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
                    //startActivity(Intent(this, FavoritosActivity::class.java))// Acción para el elemento "Favoritos"
                    true
                }
                else -> false
            }
        }
    }
}
