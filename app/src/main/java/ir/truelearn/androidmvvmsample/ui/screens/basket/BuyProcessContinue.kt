package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightRed
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun BuyProcessContinue(
    price: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.padding(horizontal = 1.dp),
        shape = RoundedCornerShape(3.dp),
        elevation = 15.dp,
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.padding(4.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.DigikalaLightRed),
                onClick = { onClick() }

            ) {
                Text(
                    text = "ادامه فرایند خرید",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "جمع سبد خرید",
                    color = Color.Gray,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "${DigitHelper.digitBySeparator(DigitHelper.digitByLocate(price))} ${
                        stringResource(
                            id = R.string.price_unit
                        )
                    }",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold,
                )
            }

        }
    }
}