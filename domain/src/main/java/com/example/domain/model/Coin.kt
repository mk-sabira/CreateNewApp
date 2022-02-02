package com.example.domain.model

import com.example.data.remote.dto.Bpi
import com.example.data.remote.dto.Time

data class Coin(
    val id: String,
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
){
}