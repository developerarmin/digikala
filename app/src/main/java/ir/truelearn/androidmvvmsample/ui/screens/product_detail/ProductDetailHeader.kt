package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.layout.*
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
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate

@Composable
fun ProductDetailHeader(item:AmazingItem) {
    Column {
        Text(
            text = "عنوان دسته بندی محصول",
            color = MaterialTheme.colors.DarkCyan,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium)
        )
        Text(
            text = item.name,
            color = Color.Black,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.medium,
                vertical = MaterialTheme.spacing.small
            ),
            maxLines = 2

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                modifier = Modifier.size(15.dp),
                tint = MaterialTheme.colors.Gold
            )
            Text(
                text = digitByLocate("4.3"),
                color = MaterialTheme.colors.semiDarkText,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.miniDp + 1.dp)
            )
            Text(
                text = digitByLocate("(173)"),
                color = MaterialTheme.colors.grayAlpha,
                fontSize = 12.sp,
                modifier = Modifier.padding(end = MaterialTheme.spacing.miniDp + 8.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.dot),
                contentDescription = "",
                tint = MaterialTheme.colors.grayAlpha,
                modifier = Modifier
                    .size(25.dp)
                    .padding(horizontal = MaterialTheme.spacing.miniDp + 9.dp)
            )
            Text(
                text = DigitHelper.digitByLocate("116 دیدگاه کاربران"),
                color = MaterialTheme.colors.DarkCyan,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
            )
            Icon(
                painter = painterResource(id = R.drawable.dot),
                contentDescription = "",
                tint = MaterialTheme.colors.grayAlpha,
                modifier = Modifier
                    .size(25.dp)
                    .padding(horizontal = MaterialTheme.spacing.miniDp + 9.dp)
            )
            Text(
                text = DigitHelper.digitByLocate("6 پرسش و پاسخ"),
                color = MaterialTheme.colors.DarkCyan,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.like),
                contentDescription = "",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.DigikalaLightGreen
            )
            Text(
                text = DigitHelper.digitByLocate("90% (80نفر) از خریداران این کالا را پیشنهاد کرده اند."),
                color = MaterialTheme.colors.semiDarkText,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small))
        }
    }
}