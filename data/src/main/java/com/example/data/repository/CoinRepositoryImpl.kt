package com.example.data.repository

import com.example.data.remote.CoinDeskApi
import com.example.domain.model.CoinDto
import com.example.domain.repository.CoinRepository
import retrofit2.Response

class CoinRepositoryImpl(
    val api: CoinDeskApi
): CoinRepository {

    override suspend fun getCoins(): Response<CoinDto> {
        return api.getCoins()
    }
}