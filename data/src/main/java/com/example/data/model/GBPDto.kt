package com.example.data.model

import com.example.data.mapper.GBP

data class GBPDto(
    val code: String? = null,
    val description: String? = null,
    val rate: String? = null,
    val rate_float: Double? = null,
    val symbol: String? = null
)

