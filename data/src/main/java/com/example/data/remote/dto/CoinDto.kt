package com.example.data.remote.dto

import com.example.domain.model.Coin
import com.example.mycryptoapp.data.remote.dto.Time

data class CoinDto(
    val id: String,
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
)
