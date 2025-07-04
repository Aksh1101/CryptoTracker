package com.plcoding.cryptotracker.core.data.networking

import com.plcoding.cryptotracker.BuildConfig


fun constructUrl(url: String): String {
    val baseUrl = BuildConfig.BASE_URL
    val apiKeyParam = "apiKey=${BuildConfig.API_KEY}"

    val fullUrl = when {
        url.contains(baseUrl) -> url
        url.startsWith("/") -> baseUrl + url.drop(1)
        else -> baseUrl + url
    }

    return if (fullUrl.contains("?")) {
        "$fullUrl&$apiKeyParam"
    } else {
        "$fullUrl?$apiKeyParam"
    }
}

