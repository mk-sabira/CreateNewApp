package com.example.mycryptoapp.di

import com.example.data.repository.CoinRepository
import com.example.domain.use_case.GetCoinsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCoinUseCase(coinRepository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepository)
    }
}