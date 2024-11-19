package com.example.gamesapi.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    fun getApi(): GamesApi {
        return getRetrofit().create(GamesApi::class.java)

    }
}