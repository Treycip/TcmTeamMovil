package com.mamani.xavier.tecmedia.publication.favoritos

import com.mamani.xavier.tecmedia.publication.Api.PublicacionX


object FavoritosManager {
    private val favoritosList = mutableListOf<PublicacionX>()

    fun agregarPublicacion(publicacion: PublicacionX) {
        favoritosList.add(publicacion)
    }

    fun obtenerFavoritos(): List<PublicacionX> {
        return favoritosList.toList()
    }
    fun limpiarFavoritos() {
        favoritosList.clear()
    }

    // Puedes implementar más métodos según tus necesidades
}
