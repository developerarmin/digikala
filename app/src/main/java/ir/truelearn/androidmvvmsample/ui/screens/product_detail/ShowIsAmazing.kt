package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightRed
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun ShowIsAmazing(isAmazing:Boolean){
    if (isAmazing){
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.height(50.dp).fillMaxWidth().padding(horizontal = MaterialTheme.spacing.medium)) {
            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)){
                Text(
                    text = "پیشنهاد شگفت انگیز",
                    color = MaterialTheme.colors.DigikalaLightRed,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold

                )
                Text(
                    text = DigitHelper.digitByLocate("24 : 25 : 19") ,
                    color = MaterialTheme.colors.DigikalaLightRed,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Divider(color = MaterialTheme.colors.DigikalaLightRed, thickness = 2.dp)
        }
    }

}