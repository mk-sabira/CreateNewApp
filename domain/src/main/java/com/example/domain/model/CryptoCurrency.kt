package com.example.domain.model

data class CryptoCurrency(
    val code: String? = null,
    val description: String? = null,
    val rate: String? = null,
    val rate_float: Double? = null,
    val symbol: String? = null
)
