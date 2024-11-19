package com.example.gamesapi.data


class GamesRepository {

    val api = RetrofitInstance.getApi()

    suspend fun getApi(): List<Game>? {
       return try {
            val gamesResponse = RetrofitInstance.getApi().getGamesList()
            if (gamesResponse.isSuccessful) {
                return  gamesResponse.body()
            } else {
                null
            }
        } catch (error: Exception) {
            null
        }
    }



}