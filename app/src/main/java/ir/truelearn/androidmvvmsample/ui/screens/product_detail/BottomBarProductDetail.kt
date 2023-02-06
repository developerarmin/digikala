package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.FavoriteProduct
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaDarkRed
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun BootomBarProductDetail(navController: NavController){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = MaterialTheme.spacing.medium)
            .background(Color.White)

        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(0.6f)) {
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(44.dp)
                    .background(
                        color = MaterialTheme.colors.DigikalaDarkRed,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable { }
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.CenterVertically),

                ) {
                Text(
                    text = "افزودن به سبد خرید",
                    color = Color.White,
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        //Spacer(modifier = Modifier.width(140.dp))
        Column() {
            Row() {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(24.dp)
                        .background(
                            color = MaterialTheme.colors.DigikalaDarkRed,
                            shape = CircleShape
                        )
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .wrapContentHeight(Alignment.CenterVertically),

                    ) {
                    Text(
                        text = DigitHelper.digitByLocate("21%"),
                        color = Color.White,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,

                        )
                }
                Spacer(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraSmall))
                Text(
                    text = DigitHelper.digitByLocate("100,000"),
                    color = Color.LightGray,
                    style = MaterialTheme.typography.body1,
                    textDecoration = TextDecoration.LineThrough,
                )
            }
            Text(
                text =DigitHelper.digitByLocate( "100,000 ${
                    stringResource(
                        id = R.string.price_unit
                    )
                }"),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )

        }





    }
}




