package ir.truelearn.androidmvvmsample.ui.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun CheckoutProductCard(item: CartItem) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(75.dp)
            .width(75.dp)
    ) {



        Box(
            modifier = Modifier
                .height(75.dp)
                .width(75.dp)
            ,
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = "cart item Photo",
                contentScale = ContentScale.FillBounds
            )
//            Image(
//                painterResource(id = R.drawable.hamberger),
//                contentDescription = "product",
//                contentScale = ContentScale.FillBounds
//            )
        }

        Box(
            modifier = Modifier
                .height(75.dp)
                .width(75.dp)
                .clip(RoundedCornerShape(4.dp))
            ,
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = " 1 ",
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                modifier = Modifier
                    .background(Color(0xFFF7F7F7))


            )
        }


    }
    Divider(
        color = Color(0xFFF3F3F3),
        modifier = Modifier
            .height(70.dp)  //fill the max height
            .width(1.dp)

    )
}

