package com.chiefdeveloper.financeapp.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class Cards(
    val cardType: String,
    val accountType: String,
    val accountBalance: Double,
    val cardNumber: String,
    val colorBrush: Brush
)

