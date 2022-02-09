package com.example.domain.use_case

import com.example.domain.model.CoinDto
import com.example.domain.repository.CoinRepository
import retrofit2.Response

class GetCoinsUseCase(val repository: CoinRepository) {

    suspend fun getCoin(): Response<CoinDto> {
        return repository.getCoins()
    }

}