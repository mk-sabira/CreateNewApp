package com.example.data.model

import com.example.data.mapper.Coin

data class CoinDto(
    val chartName: String,
    val time: TimeDto,
    val disclaimer: String,
    val bpi: BpiDto
)

