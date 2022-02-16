package com.example.mycryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.data.model.CoinDto
import com.example.mycryptoapp.common.App
import com.example.mycryptoapp.databinding.ActivityMainBinding
import com.example.mycryptoapp.presentation.coin_list.CoinAdapter
import com.example.mycryptoapp.presentation.coin_list.CoinViewModel
import com.example.mycryptoapp.presentation.coin_list.CoinViewModelFactory
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


        viewModel.getCoin()

        viewModel._liveData.observe(this, Observer {

            val coinName = CoinDto(it.chartName, it.time, it.disclaimer, it.bpi)

            coinList.add(coinName)
            coinAdapter.setListCoins(coinList)

        })


    }

}