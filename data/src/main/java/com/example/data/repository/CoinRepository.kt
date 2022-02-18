package com.example.data.repository

import com.example.data.mapper.Coin
import com.example.data.model.CoinDto
import retrofit2.Response

interface CoinRepository {

    suspend fun getCoins(): Response<CoinDto>
}