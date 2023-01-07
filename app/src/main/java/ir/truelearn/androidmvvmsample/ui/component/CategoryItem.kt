package ir.truelearn.androidmvvmsample.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R

@Composable
fun CategoryItem() {

    val productTitle = "گوشی موبایل"
    val amount = "  +۲۰۰۰ کالا"

    Card(
        modifier = Modifier
            .width(140.dp)
            .background(colorResource(id = R.color.white))
            .padding(top = 16.dp, bottom = 16.dp, start = 5.dp, end = 5.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.gray_category))
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painterResource(id = R.drawable.place_holder),
                contentDescription = "product image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = productTitle,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = amount,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )


        }
    }
}