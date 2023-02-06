package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.infoBox
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitBySeparator
import ir.truelearn.androidmvvmsample.util.Dimension

@Composable
fun DigiKlabScore(
    score: String
) {
    Divider(
        color = infoBox,
        thickness = 1.dp,
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)

    )

Row(
modifier = Modifier
.fillMaxWidth(),
horizontalArrangement = Arrangement.SpaceBetween,
verticalAlignment = Alignment.CenterVertically
) {


    Image(
        painter = painterResource(id = R.drawable.digi_score),
        contentDescription = "",
        modifier = Modifier.size(18.dp, 18.dp)
            .weight(0.05f)
            .align(Alignment.CenterVertically)
    )

    Text(
        text = "امتیاز دیجی‌کلاب",
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Medium,
        color = Color.Gray,
        fontFamily = font_standard,
        modifier = Modifier
            .weight(0.65f)
    )



    Text(

        text = "${digitBySeparator(digitByLocate(score))} امتیاز ",
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.body2,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        modifier = Modifier
            .weight(0.3f)
    )
}

        Text(
            text = "بعد از پایان مهلت مرجوعی، برای دریافت امتیاز به صفحه ماموریت‌های کلابی سر بزنید.",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
            fontFamily = font_standard,
            modifier = Modifier
                .padding(MaterialTheme.spacing.mediumTwo,)
        )
}