package com.example.data.remote

import com.example.data.model.CoinDto
import retrofit2.Response
import retrofit2.http.GET

interface CoinDeskApi {

    @GET("/v1/bpi/currentprice.json")
    suspend fun getCoins(): Response<CoinDto>
}