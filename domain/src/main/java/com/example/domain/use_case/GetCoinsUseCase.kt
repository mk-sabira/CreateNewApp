package com.example.domain.use_case


import com.example.data.mapper.Coin
import com.example.data.model.CoinDto
import com.example.data.repository.CoinRepository
import retrofit2.Response

class GetCoinsUseCase(val repository: CoinRepository) {

    suspend fun getCoin(): Response<CoinDto> {
        return repository.getCoins()
    }

}