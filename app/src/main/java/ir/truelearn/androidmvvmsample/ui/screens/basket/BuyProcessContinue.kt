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
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.screens.profile.DigikalaButton
import ir.truelearn.androidmvvmsample.ui.theme.*
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
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.digikalaRed),
                modifier = Modifier
                    .padding(
                        start = MaterialTheme.spacing.semiLarge,
                        end = MaterialTheme.spacing.semiLarge,
                        bottom = MaterialTheme.spacing.medium,
                        top = MaterialTheme.spacing.medium
                    ),
                shape = MaterialTheme.roundedShape.small
            ) {
                Text(
                    text = "ادامه فرایند خرید",
                    color = Color.White,
                    fontFamily = font_standard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
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
                    fontWeight = FontWeight.SemiBold,
                    style = SmallFont.body1,
                    color = MaterialTheme.colors.semiDarkText,
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