package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.mapper.Bpi
import com.example.data.mapper.Time

@Entity
data class CoinEntity(
    @PrimaryKey
    val id: Int,
    val chartName: String,
    val time: Time,
    val disclaimer: String,
    val bpi: Bpi
)
