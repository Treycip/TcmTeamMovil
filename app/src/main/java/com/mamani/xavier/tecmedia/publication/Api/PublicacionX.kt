package com.mamani.xavier.tecmedia.publication.Api

data class PublicacionX(
    val categoria: String,
    val contenido: String,
    val email: String,
    val fecha_pub: String,
    val publicacionid: Int,
    val titulo: String,
    val url: String,
    // Otros atributos del restaurante
    var esFavorito: Boolean = false
)