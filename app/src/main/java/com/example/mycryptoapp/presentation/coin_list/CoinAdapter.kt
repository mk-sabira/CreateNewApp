package com.example.mycryptoapp.presentation.coin_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CoinDto
import com.example.mycryptoapp.R
import com.example.mycryptoapp.databinding.ItemCoinViewHolderBinding

class CoinAdapter() : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    var dataSet = ArrayList<CoinDto>()

    @SuppressLint("NotifyDataSetChanged")
    fun setListCoins(list: List<CoinDto>) {
        this.dataSet = list as ArrayList<CoinDto>
        notifyDataSetChanged()
    }

    inner class CoinViewHolder(val binding: ItemCoinViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun onBind(currencyData: CoinDto) {

            binding.cryptoNameTv.text = currencyData.chartName
            binding.priceUsdTv.text = currencyData.bpi.USD.rate.toString()
            binding.priceEurTv.text = currencyData.bpi.EUR.rate.toString()
            binding.priceGbpTv.text = currencyData.bpi.GBP.rate.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = ItemCoinViewHolderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.onBind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}