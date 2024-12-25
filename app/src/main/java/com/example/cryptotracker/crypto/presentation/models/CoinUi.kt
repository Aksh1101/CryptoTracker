package com.example.cryptotracker.crypto.presentation.models

import android.icu.number.NumberFormatter
import androidx.annotation.DrawableRes
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id : String,
    val rank : Int,
    val name : String,
    val symbol : String,
    val marketCapUsd : DisplayableNumber,
    val priceUsd : DisplayableNumber,
    val changePercent24Hr : DisplayableNumber,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumber(
    val value : Double,
    val formatted : String
)

fun Coin.toCoinUi() : CoinUi {
    return CoinUi(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)


    )
}

fun Double.toDisplayableNumber() : DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 3
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}