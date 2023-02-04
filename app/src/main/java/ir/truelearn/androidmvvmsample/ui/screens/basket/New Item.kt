package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TestKotlin() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Green)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, top = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.MoreVert, contentDescription = "More Options"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "کالاهای سوپر مارکتی")
                Text(
                    text = "1 کالا",
                    style = TextStyle(
                        textDirection = TextDirection.ContentOrRtl
                    )
                )
            }

        }
        Row() {


            Column(
                modifier = Modifier
                .padding(top = 24.dp)

            ) {
                Text(text = "نان همبرگر نان آوران بسته یک عددی",
                modifier = Modifier.padding(start = 80.dp),
                fontSize = 16.sp)

                Row(modifier = Modifier
                    .padding(top = 4.dp, start = 90.dp)) {
                    Text(text = "گارانتی اصالت و سلامت فیزیکی کالا")
                    Icon(painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.warranty),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp))
                }

                Row(modifier = Modifier
                    .padding(top = 4.dp, start = 225.dp)) {
                    Text(text = "دیجی کالا")
                    Icon(painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.store),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp))
                }

                Row(modifier = Modifier
                    .padding(top = 4.dp, start = 148.dp)) {
                    Text(text = "موجود در انبار دیجی کالا")
                    Icon(painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.available),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp))
                }

                Row(modifier = Modifier
                    .padding(top = 4.dp, start = 90.dp)) {
                    Text(text = "ارسال سریع سوپر مارکتی دیجی کالا")
                    Icon(painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.available),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp))
                }

                Row(modifier = Modifier
                    .padding(top = 32.dp, start = 200.dp)) {
                    Icon(painter = painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.toman),
                        contentDescription = "Toman",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(32.dp))

                    Text(text = "7,990",
                    fontSize = 24.sp)
                }
            }

            Column(modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End) {
                Image(
                    painter = painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.hamberger),
                    contentDescription = "Article Photo",
                    modifier = Modifier
                        .padding(end = 24.dp, top = 32.dp)
                )
                Card(
                    modifier = Modifier
                        .padding(top = 32.dp, end = 16.dp)
                        .height(40.dp)
                        .width(110.dp),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(
                            painterResource(id = ir.truelearn.androidmvvmsample.R.drawable.digi_trash),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(top = 10.dp)
                        )
                        Text(
                            text = "1",
                            modifier = Modifier
                                .padding(top = 10.dp)
                        )
                        Text(
                            text = "+",
                            modifier = Modifier
                                .padding(top = 10.dp)
                        )
                    }
                }
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 32.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                modifier = Modifier
                    .padding(top = 2.dp)
            )
            Text(text = "ذخیره در لیست خرید بعدی",
                modifier = Modifier
                    .clickable { })
        }

    }
}

@Composable
@Preview
fun KotkinPreview() {
    TestKotlin()
}