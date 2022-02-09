package com.example.domain.model

data class CoinDto(
    val chartName: String,
    val time: Time,
    val disclaimer: String,
    val bpi: Bpi
)
