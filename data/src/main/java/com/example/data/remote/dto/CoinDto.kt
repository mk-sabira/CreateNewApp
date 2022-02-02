package com.example.data.remote.dto

data class CoinDto(
    val time: Time,
    val disclaimer: String,
    val chartName: String,
    val bpi: Bpi
)