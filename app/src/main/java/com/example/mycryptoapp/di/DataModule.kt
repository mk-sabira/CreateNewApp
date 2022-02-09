package com.example.mycryptoapp.di

import com.example.data.remote.CoinDeskApi
import com.example.data.repository.CoinRepositoryImpl
import com.example.domain.repository.CoinRepository
import com.example.mycryptoapp.common.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class DataModule {

     @Provides
     fun provideCoinRepository(coinDeskApi: CoinDeskApi): CoinRepository {
         return CoinRepositoryImpl(coinDeskApi)
     }
}

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getHttpLoginInterceptor()).build()
    }

    @Provides
    fun getHttpLoginInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton

    internal fun getCoinDeskApi(retrofit: Retrofit): CoinDeskApi{
        return retrofit.create(CoinDeskApi::class.java)
    }



}