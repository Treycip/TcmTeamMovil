package com.mamani.xavier.tecmedia.mapa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mamani.xavier.tecmedia.R
import com.mamani.xavier.tecmedia.publication.MainActivityRes
import com.mamani.xavier.tecmedia.publication.favoritos.FavoritosActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigationView() // Configurar el BottomNavigationView

    }

    private fun setupBottomNavigationView() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_inicio -> {
                    // Acción para el elemento "Inicio"
                    true
                }

                R.id.action_publicacions -> {
                    startActivity(
                        Intent(
                            this,
                            MainActivityRes::class.java
                        )
                    )// Acción para el elemento "Publicacions"
                    true
                }

                R.id.action_favoritos -> {
                    startActivity(
                        Intent(
                            this,
                            FavoritosActivity::class.java
                        )
                    )// Acción para el elemento "Favoritos"
                    true
                }

                else -> false
            }
        }

    }


}




