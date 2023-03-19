package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.Purple
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun OnlineShoppingAdviceCard(){
    Card(shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .padding(MaterialTheme.spacing.small)
            .fillMaxWidth()
            .wrapContentHeight(), contentColor = Color.White, elevation = 1.dp) {
        Column(horizontalAlignment =  Alignment.Start,
            modifier = Modifier.padding(MaterialTheme.spacing.small)) {


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Image(painter = painterResource(id = R.drawable.pindo), contentDescription ="",
                        modifier = Modifier
                            .size(20.dp)
                            .weight(0.1f)
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = "مشاوره خرید آنلاین",
                        fontFamily = font_standard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.weight(0.8f)
                    )

                    Image(painter = painterResource(id = R.drawable.arrow_forward),
                        contentDescription = "arrow",
                        modifier = Modifier.weight(0.1f)
                    )
                }




        }
    }
}