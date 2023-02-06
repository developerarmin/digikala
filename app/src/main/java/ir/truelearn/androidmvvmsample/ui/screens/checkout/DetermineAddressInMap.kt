package ir.truelearn.androidmvvmsample.ui.screens.checkout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.DarkAmper
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.spacing


@Composable
fun DetermineAddressInMap() {

    Row(
        modifier = Modifier
            .padding(bottom = MaterialTheme.spacing.mediumTwo)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.info),
            contentDescription = "",
            tint = DarkAmper,
            modifier = Modifier
                .size(22.dp, 22.dp)
                .weight(0.1f)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(0.027f))
        Text(
            modifier = Modifier
                .weight(0.73f),
            text = "موقعیت این آدرس بر روی نقشه تعیین نشده. برای ادامه وجود موقعیت الزامی است.",
            textAlign = TextAlign.Start,
            color = DarkAmper,
            style = MaterialTheme.typography.body2,
            fontFamily = font_standard,
        )
        Spacer(modifier = Modifier.weight(0.025f))
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "",
            tint = DarkAmper,
            modifier = Modifier
                .size(18.dp, 18.dp)
                .weight(0.1f)
                .align(Alignment.CenterVertically)
        )
    }
}