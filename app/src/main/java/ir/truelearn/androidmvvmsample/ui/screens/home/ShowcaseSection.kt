package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.component.CircularIconBox
import ir.truelearn.androidmvvmsample.ui.component.RoundedIconBox


@Composable
fun ShowcaseSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "دیجی کالا جت"
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "حراج استایل"
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "خرید اقساطی"
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "دیجی کالا مهر"
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "پیشنهاد روز زن"
            )
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "کارت هدیه"
            )
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "حراج طلا"
            )
            CircularIconBox(
                image = painterResource(id = R.drawable.digi_logo),
                title = "بیشتر"
            )
        }
    }
}