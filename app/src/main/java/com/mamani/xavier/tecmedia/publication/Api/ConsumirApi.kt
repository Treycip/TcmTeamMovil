package com.mamani.xavier.tecmedia.publication.Api


import retrofit2.Call
import retrofit2.http.GET

interface ConsumirApi {
    @GET("db")
    fun getTraer(): Call<Publicacion>
}
