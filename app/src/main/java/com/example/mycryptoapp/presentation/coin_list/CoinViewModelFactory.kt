package com.example.mycryptoapp.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.use_case.GetCoinsUseCase

class CoinViewModelFactory(val coin: GetCoinsUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CoinViewModel(coin) as T
    }
}