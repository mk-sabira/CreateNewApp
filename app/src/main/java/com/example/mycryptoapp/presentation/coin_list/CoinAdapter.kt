package com.example.mycryptoapp.presentation.coin_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.mapper.Coin
import com.example.mycryptoapp.databinding.ItemCoinViewHolderBinding

class CoinAdapter: RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    var dataSet = ArrayList<Coin>()

    fun setListCoins(list: ArrayList<Coin>) {
        this.dataSet = list as ArrayList<Coin>
        notifyDataSetChanged()
    }

    inner class CoinViewHolder(val binding: ItemCoinViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(currencyData: Coin) {

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