package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_bold
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun CartPriceRow(title:String,price:Int,discount:Int=0){
var color =Color.Black
    var _price = "0"
    if (discount>0){
        _price ="(${DigitHelper.digitByLocate(discount.toString())}%)${DigitHelper.digitByLocate(price.toString())}"
        color=Color.Red
    }else {
        _price = DigitHelper.digitByLocate(price.toString())
        color=Color.Black
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(){
            Text(
                modifier = Modifier
                ,
                text = title,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.darkText,
                fontFamily = font_bold,
                maxLines=2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row() {
            Text(
                text = _price,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = color
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