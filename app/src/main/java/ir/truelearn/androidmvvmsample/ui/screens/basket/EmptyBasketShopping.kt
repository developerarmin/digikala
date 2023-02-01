package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.semiDarkText

@Composable
fun EmptyBasketShopping() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.empty_chart),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "سبد خرید شما خالی است!",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.semiDarkText,
            )
        }
    }



