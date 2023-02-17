package ir.truelearn.androidmvvmsample.ui.screens.product_detail

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
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.ui.theme.Purple
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun DigiPlusCard(){
    Card(shape = RoundedCornerShape(18.dp), modifier = Modifier
        .padding(MaterialTheme.spacing.small)
        .fillMaxWidth()
        .height(70.dp), contentColor = Color.White, elevation = 2.dp) {
    Column(horizontalAlignment =  Alignment.Start, modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
Row(verticalAlignment = Alignment.CenterVertically) {
    Icon(painter = painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.digi_plus_icon), contentDescription ="", modifier = Modifier.size(15.dp), tint =  MaterialTheme.colors.Purple)
    Spacer(modifier = Modifier.width(5.dp))
    Text(text = "ارسال رایگان سفارش ها برای اعضای دیجی پلاس", style = MaterialTheme.typography.h5, color = MaterialTheme.colors.Purple)
}
        Text(text = "29 هزار تومان هزینه ارسال به سراسر ایران برای کاربران غیر دیجی پلاس", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.darkText)
    }
    }
}