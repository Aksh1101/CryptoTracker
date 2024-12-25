package com.example.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.crypto.presentation.models.CoinUi
import com.example.cryptotracker.crypto.presentation.models.toCoinUi
import com.example.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun Coin_listItem(
    coinUi: CoinUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable (onClick = onClick )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = modifier.size(85.dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text= coinUi.symbol,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
    }

}

@PreviewLightDark
@Composable
private fun CoinListItemPreview(){
    CryptoTrackerTheme {
        Coin_listItem(
            coinUi = previewCoin,
            onClick = {},
            modifier = Modifier.background(
                MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 123457276288.78,
    priceUsd = 63823.35,
    changePercent24Hr = 0.1
).toCoinUi()