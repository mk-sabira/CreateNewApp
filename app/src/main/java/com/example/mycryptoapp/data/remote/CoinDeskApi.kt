package com.example.mycryptoapp.data.remote

import retrofit2.http.GET

interface CoinDeskApi {

    @GET("/v1/bpi/currentprice.json")
    suspend fun getCoins()
}