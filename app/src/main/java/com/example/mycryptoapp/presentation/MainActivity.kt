package com.example.mycryptoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.mycryptoapp.R
import com.example.mycryptoapp.common.Constants.BASE_URL
import com.example.data.remote.CoinDeskApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinDeskApi::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            val response = api.getCoins()
            if (response.isSuccessful) {
                for (coin in response.body()!!) {
                    Log.d(TAG, coin.toString())
                }
            }
        }
    }

}