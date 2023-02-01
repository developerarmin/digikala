package ir.truelearn.androidmvvmsample.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun IconWithBadget(badget: Int, icon: Painter) {
    Card(
        modifier = Modifier
            .height(24.dp)

    ) {
        Box(
            modifier = Modifier
                .height(24.dp)
        )
        {
            Icon(
                painter = icon,
                contentDescription = "",
                modifier = Modifier
                    .height(24.dp),
            )
        }
        Box(
            modifier = Modifier
                .height(24.dp)
            ,
            contentAlignment = Alignment.BottomStart
        )
        {
            Text(
                text = "${DigitHelper.digitBySeparator(DigitHelper.digitByLocate(badget.toString()))} ",
                modifier = Modifier
                    .background(color = MaterialTheme.colors.digikalaRed)
                    .height(13.dp)
                    .padding(top = 0.dp, bottom = 0.dp, start = 3.dp, end = 2.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp,
                color = Color.White,
            )
        }

    }

}