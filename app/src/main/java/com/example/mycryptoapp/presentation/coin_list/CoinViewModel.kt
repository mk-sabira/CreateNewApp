package com.example.mycryptoapp.presentation.coin_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CoinDto
import com.example.domain.use_case.GetCoinsUseCase
import kotlinx.coroutines.launch

class CoinViewModel(val coin: GetCoinsUseCase) : ViewModel() {

    val _mLiveData = MutableLiveData<CoinDto>()
    val _liveData: LiveData<CoinDto> = _mLiveData

    suspend fun getCoin() {

        viewModelScope.launch {
            val response = coin.getCoin()

            if (response.isSuccessful) {
                _mLiveData.postValue(response.body())
            } else {
                Log.e("Response Error", "something went wrong")
            }
        }
    }
}