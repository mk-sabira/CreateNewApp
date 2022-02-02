package com.example.mycryptoapp.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.data.remote.CoinDeskApi
import com.example.mycryptoapp.R
import com.example.mycryptoapp.common.Constants.BASE_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val TAG = "TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinDeskApi::class.java)
        lifecycleScope.launch(Dispatchers.Main) {
            val response = api.getCoins()
            val coins = response.body()
            textView.text = coins?.toString()
        }
    }

}