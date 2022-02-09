package com.example.domain.repository

import com.example.domain.model.CoinDto
import retrofit2.Response

interface CoinRepository {

    suspend fun getCoins(): Response<CoinDto>
}