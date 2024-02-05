package com.chiefdeveloper.financeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiefdeveloper.financeapp.data.Cards
import com.chiefdeveloper.financeapp.ui.theme.GreenEnd
import com.chiefdeveloper.financeapp.ui.theme.GreenStart
import com.chiefdeveloper.financeapp.ui.theme.OrangeEnd
import com.chiefdeveloper.financeapp.ui.theme.OrangeStart
import com.chiefdeveloper.financeapp.ui.theme.PurpleEnd
import com.chiefdeveloper.financeapp.ui.theme.PurpleStart

val cards = listOf<Cards>(
    // Creating a list of the Cards

    Cards("VISA",
        "Business",
        45.765,
        "0113 268646",
        colorBrush = getGradient(PurpleStart, PurpleEnd)

    ),

    Cards("MASTER CARD",
        "Shopping",
        26.750,
        "0726 793517",
        colorBrush = getGradient(GreenStart, GreenEnd)
    ),
    Cards("VISA",
        "School",
        24.875,
        "0720 792413",
        colorBrush = getGradient(OrangeStart, OrangeEnd)
    ),

    Cards("MASTER CARD",
        "Exclusive",
        6.865,
        "0113 268646",
        colorBrush = getGradient(PurpleStart, PurpleEnd)
    )

)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            startColor, endColor
        )
    )
}



@Composable
@Preview
fun CardRow() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            LazyRow{
                items(cards.size){index ->
                    CardItem(index)
                    //
                }
            }
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPaddingValues = 0.dp

    if(index == cards.size -1){
        lastItemPaddingValues = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)

    if(card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box (modifier = Modifier
        .padding(start = 10.dp, end = lastItemPaddingValues)
        .clip(RoundedCornerShape(25.dp))
    ){

        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.colorBrush)
            .width(250.dp)
            .height(160.dp)
            .padding(vertical = 10.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ){
            
            Image(painter = image,
                contentDescription = "Card",
                modifier = Modifier.size(50.dp))

            Text(text = card.accountType,
                fontSize = 18.sp,
                color = Color.White)

            Text(text = " $ ${card.accountBalance}",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)

            Text(text = card.cardNumber,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)

        }


    }
}



