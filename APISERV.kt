package com.example.fragment_traning

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APISERV {
    @GET("games")
    fun oyunAl(

        @Query("key") aKey:String
    ): Call<JSON>
    @GET("games/{id}")
    fun getGameDescription (@Path("id") id: Int,
                            @Query("key") aKey: String): Call<DETAILSSS>
}
