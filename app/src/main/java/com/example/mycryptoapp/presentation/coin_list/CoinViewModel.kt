package com.example.mycryptoapp.presentation.coin_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.mapper.Coin
import com.example.data.model.CoinDto
import com.example.domain.use_case.GetCoinsUseCase
import kotlinx.coroutines.launch

class CoinViewModel(val coin: GetCoinsUseCase) : ViewModel() {

    val _mLiveData = MutableLiveData<Coin>()
    val _liveData: LiveData<Coin> = _mLiveData

    fun getCoin() {

        viewModelScope.launch {
            val response = coin.getCoin()

            if (response.isSuccessful) {
                _mLiveData.postValue(response.body()?.toCoin())
            } else {
                Log.e("Response Error", "something went wrong")
            }
        }
    }
}