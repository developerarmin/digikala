package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
        modifier = Modifier.padding(horizontal = 0.dp),
        shape = RoundedCornerShape(3.dp),
        elevation = 5.dp,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.spacing.semiLarge,
                    end = MaterialTheme.spacing.semiLarge,
                    bottom = MaterialTheme.spacing.medium,
                    top = MaterialTheme.spacing.medium
                ),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.digikalaRed),
                modifier = Modifier

                    ,
                shape = MaterialTheme.roundedShape.small
            ) {
                Text(
                    text = stringResource(R.string.purchase_process),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(
                            start = MaterialTheme.spacing.semiLarge,
                            end = MaterialTheme.spacing.semiLarge,
                            bottom = MaterialTheme.spacing.small,
                            top = MaterialTheme.spacing.small
                        )
                )
            }
            Column(
                modifier = Modifier
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.total_shopping_cart),
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.semiDarkText,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row() {
                    Text(
                        text = "${DigitHelper.digitBySeparator(DigitHelper.digitByLocate(price))}",
                        //" ${stringResource(id = R.string.price_unit)}",
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,

                    )
                    Image(
                        painter = painterResource(id = R.drawable.toman),
                        contentDescription ="",
                        modifier = Modifier
                            .size(MaterialTheme.spacing.semiLarge)
                            .padding(horizontal = MaterialTheme.spacing.extraSmall)
                    )

                }

            }
        }
    }
}