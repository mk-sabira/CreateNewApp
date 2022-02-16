package com.example.mycryptoapp.di

import android.content.Context
import com.example.domain.use_case.GetCoinsUseCase
import com.example.mycryptoapp.presentation.coin_list.CoinViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideCoinVMFactory(coinsUseCase: GetCoinsUseCase): CoinViewModelFactory{
        return CoinViewModelFactory(coinsUseCase)
    }

}