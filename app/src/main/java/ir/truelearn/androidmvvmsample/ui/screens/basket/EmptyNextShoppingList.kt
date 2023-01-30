package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.semiDarkText
import ir.truelearn.androidmvvmsample.util.Dimention


@Composable
fun EmptyNextShoppingList() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.empty_next_chart),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "لیست خرید بعدی شما خالی است!",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "شما میتوانید محصولاتی که به سبد خرید خود افزوده اید و فعلا قصد خرید آنها را ندارید، در لیست خرید بعدی قرار داده و هر زمان مایل بودید آنها را به سبد خرید اضافه کرده و خرید آنها را تکمیل کنید.",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.semiDarkText,
                modifier = Modifier
                    .width(Dimention.width(80f).dp)
                ,
                textAlign = TextAlign.Center
            )
        }
    }
