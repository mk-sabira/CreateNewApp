package com.example.data.remote.dto

import com.example.mycryptoapp.data.remote.dto.EUR
import com.example.mycryptoapp.data.remote.dto.GBP
import com.example.mycryptoapp.data.remote.dto.USD

data class Bpi(
    val EUR: EUR,
    val GBP: GBP,
    val USD: USD
)