package com.example.mycryptoapp.presentation.coin_list

import com.example.data.mapper.*
import com.example.data.model.*


fun CoinDto.toCoin() =
    Coin(
        chartName = chartName,
        time = time.toTime(),
        disclaimer = disclaimer,
        bpi = bpi.toBpi()

    )



private fun BpiDto.toBpi() =
    Bpi(
        EUR = EUR.toEuro(),
        GBP = GBP.toGBP(),
        USD = USD.toUSD()
    )


private fun EURDto.toEuro() =
    EUR(
        code = code,
        description = description,
        rate = rate,
        rate_float = rate_float,
        symbol = symbol
    )

private fun GBPDto.toGBP() =
    GBP(
        code = code,
        description = description,
        rate = rate,
        rate_float = rate_float,
        symbol = symbol
    )

fun USDDto.toUSD() =
    USD(
        code = code,
        description = description,
        rate = rate,
        rate_float = rate_float,
        symbol = symbol
    )

private fun TimeDto.toTime() =
    Time(
        updated = updated,
        updatedISO = updatedISO,
        updateduk = updateduk
    )