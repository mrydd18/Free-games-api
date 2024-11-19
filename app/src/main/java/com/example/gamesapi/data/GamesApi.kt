package com.example.gamesapi.data

import retrofit2.Response
import retrofit2.http.GET

interface GamesApi {
    @GET("games")
    suspend fun getGamesList(): Response<List<Game>>

}