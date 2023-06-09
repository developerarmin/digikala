package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun BuyProcessContinue(
    price: String,
    timeState: Boolean = false,
    flag: String = "ShoppingBasket",
    onClick: () -> Unit,
) {
    var payableText = ""
    payableText = if (flag == "ShoppingBasket")
        stringResource(R.string.total_shopping_cart)
    else
        stringResource(R.string.payable_price)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(3.dp),
        elevation = 5.dp,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth().padding(MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            if ((flag.equals("ShoppingBasket")) || (timeState)) {
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.digikalaRed),
                    modifier = Modifier,
                    shape = MaterialTheme.roundedShape.small
                ) {
                    Text(
                        text = stringResource(R.string.purchase_process),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                            .padding(
                                horizontal = MaterialTheme.spacing.mediumTwo,
                                vertical = MaterialTheme.spacing.small,
                            )
                    )
                }
            } else {
//                Button(
//                    onClick = {},
//                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.digikalaRed),
//                    modifier = Modifier,
//                    shape = MaterialTheme.roundedShape.small
//                ) {
//                    Text(
//                        text = stringResource(R.string.purchase_process_time),
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold,
//                        style = MaterialTheme.typography.h6,
//                        modifier = Modifier
//                            .padding(
//                                horizontal = MaterialTheme.spacing.mediumTwo,
//                            )
//                    )
//                }

                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(backgroundColor = BtnWhite),
                    modifier = Modifier,
                    border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.digikalaRed),
                    shape = MaterialTheme.roundedShape.small
                ) {
                    Text(
                        text = stringResource(R.string.send_time),
                        color = MaterialTheme.colors.digikalaRed,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier
                            .padding(
                                horizontal = MaterialTheme.spacing.extraSmall,
                                vertical = MaterialTheme.spacing.extraSmall,
                            )
                    )

                }
            }

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = payableText,
                    color = MaterialTheme.colors.semiDarkText,
//                    fontFamily = font_standard,
                    style = MaterialTheme.typography.h6,

                    )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
                Row() {
                    Text(
                        text = DigitHelper.digitBySeparator(DigitHelper.digitByLocate(price)),
                        //" ${stringResource(id = R.string.price_unit)}",
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,

                        )

                    Image(
                        painter = painterResource(id = R.drawable.toman),
                        contentDescription = "",
                        modifier = Modifier
                            .size(MaterialTheme.spacing.semiLarge)
                            .padding(horizontal = MaterialTheme.spacing.extraSmall)
                    )
                }
            }
        }
    }
}



