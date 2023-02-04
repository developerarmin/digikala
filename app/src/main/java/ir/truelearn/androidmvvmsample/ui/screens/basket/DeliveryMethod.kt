package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun cartDeliveryMethod() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 4.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "شیوه و زمان ارسال",
            fontWeight = FontWeight.Bold,
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "مرسوله 1 از 1",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()) {
//                    Icon(painter = painterResource(id = ), contentDescription = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "ارسال عادی")
                    Spacer(modifier = Modifier.width(12.dp))
//                    Icon(painter = painterResource(id = ), contentDescription = "")
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "4 کالا")
                }
                LazyRow(){

                }
                Text(text = "آماده ارسال")
                Spacer(modifier = Modifier.height(6.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()) {
                    Text(text = "هزینه ارسال")
                    Spacer(modifier = Modifier.height(8.dp).width(8.dp))
                    Text(text = "29000")
                    Spacer(modifier = Modifier.height(4.dp).width(8.dp))
                    Text(text = "تومان")

                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "انتخاب زمان ارسال")
//                    Icon(painter = painterResource(id = ), contentDescription = "")
                }
            }
        }
    }
}
