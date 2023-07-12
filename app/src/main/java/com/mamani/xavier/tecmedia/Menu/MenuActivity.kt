package com.mamani.xavier.tecmedia.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mamani.xavier.tecmedia.R
import com.mamani.xavier.tecmedia.publication.MainActivityRes
import com.mamani.xavier.tecmedia.publication.favoritos.FavoritosActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Obtén una referencia al elemento del menú correspondiente
        val menuItem = bottomNavigationView.menu.findItem(R.id.action_inicio)
        // Marca el elemento como seleccionado
        menuItem?.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_inicio -> {
                    // No se realiza ninguna acción porque ya estamos en la actividad correspondiente
                    true
                }
                R.id.action_publicacions -> {
                    startActivity(Intent(this, MainActivityRes::class.java))
                    true
                }
                R.id.action_favoritos -> {
                    startActivity(Intent(this, FavoritosActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}




