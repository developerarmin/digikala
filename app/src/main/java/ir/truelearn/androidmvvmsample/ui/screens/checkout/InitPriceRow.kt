package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.RedColor
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun InitPriceRow(title:String, price:Int, discount:Int=0){
var color =Color.Black
    var _price = "0"
    if (discount>0){
        _price ="(${DigitHelper.digitByLocate(discount.toString())}%)${DigitHelper.digitByLocate(price.toString())}"
        color=MaterialTheme.colors.RedColor
    }else {
        _price = DigitHelper.digitByLocate(price.toString())
        color=Color.Black
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
            Text(
                modifier = Modifier
                ,
                text = title,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                fontFamily = font_standard,
            )
        Row() {
            Text(
                text = _price,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Medium,
                color = color
            )

            Image(
                painter = painterResource(id = R.drawable.toman),
                contentDescription ="",
                colorFilter= ColorFilter.tint(color),
                modifier = Modifier
                    .size(MaterialTheme.spacing.semiLarge)
                    .padding(horizontal = MaterialTheme.spacing.extraSmall)
            )

        }
    }
}
