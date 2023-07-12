package com.mamani.xavier.tecmedia.publication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mamani.xavier.tecmedia.R
import com.mamani.xavier.tecmedia.databinding.ActivityMainResBinding
import com.mamani.xavier.tecmedia.mapa.MainActivity
import com.mamani.xavier.tecmedia.publication.Api.Publicacion
import com.mamani.xavier.tecmedia.publication.Api.RetrofitClient
import com.mamani.xavier.tecmedia.publication.favoritos.FavoritosActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityRes : AppCompatActivity() {

    private lateinit var binding: ActivityMainResBinding
    private lateinit var publicacionAdapter: PublicacionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainResBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationView() // Configurar el BottomNavigationView

        // Obtener datos de la API (similar a tu código original)

        val retrofitTraer = RetrofitClient.consumirApi.getTraer()

        retrofitTraer.enqueue(object : Callback<Publicacion> {
            override fun onResponse(call: Call<Publicacion>, response: Response<Publicacion>) {
                val publicacion = response.body()
                val publicacionsList = publicacion?.publicacions

                // Configurar PublicacionAdapter
                publicacionAdapter = PublicacionAdapter(publicacionsList.orEmpty())

                // Configurar LayoutManager y Adapter del RecyclerView
                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivityRes)
                binding.recyclerView.adapter = publicacionAdapter
            }

            override fun onFailure(call: Call<Publicacion>, t: Throwable) {
                Toast.makeText(this@MainActivityRes, "Error al consultar Api Rest", Toast.LENGTH_SHORT).show()
            }
        })
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
                    // Acción para el elemento "Publicacions"
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
}