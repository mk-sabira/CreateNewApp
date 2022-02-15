package com.example.mycryptoapp.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.remote.CoinDeskApi
import com.example.domain.model.CoinDto
import com.example.mycryptoapp.R
import com.example.mycryptoapp.common.App
import com.example.mycryptoapp.common.Constants.BASE_URL
import com.example.mycryptoapp.databinding.ActivityMainBinding
import com.example.mycryptoapp.presentation.coin_list.CoinAdapter
import com.example.mycryptoapp.presentation.coin_list.CoinViewModel
import com.example.mycryptoapp.presentation.coin_list.CoinViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: CoinViewModelFactory

    private lateinit var viewModel: CoinViewModel
    private lateinit var coinAdapter: CoinAdapter
    private val coinList = ArrayList<CoinDto>()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CoinViewModel::class.java)

        coinAdapter = CoinAdapter()
        binding.rv.adapter = coinAdapter


        lifecycleScope.launch {
            viewModel.getCoin()
        }

        viewModel._liveData.observe(this, Observer {

            val coinName = CoinDto(it.chartName, it.time, it.disclaimer, it.bpi)

            coinList.add(coinName)
            coinAdapter.setListCoins(coinList)

        })


    }

}