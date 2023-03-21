package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.ui.theme.Gray
import ir.truelearn.androidmvvmsample.ui.theme.LightCyan
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun RulesOfDigikala() {

    Text(
        text = buildAnnotatedString {

            withStyle(style = SpanStyle(color = MaterialTheme.colors.Gray)) {
                append("ثبت دیدگاه، به معنی موافقت با ")
            }

            pushStringAnnotation(tag = "terms", annotation = "https://google.com/policy")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.LightCyan
                )
            ) {
                append("قوانین انتشار دیجیکالا")
            }
            withStyle(style = SpanStyle(color = MaterialTheme.colors.Gray)) {
                append("  است.")
            }
            addStringAnnotation(
                tag = "terms",
                annotation = "https://developer.android.com/jetpack/compose",
                start = 6,
                end = 21
            )
            toAnnotatedString()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.large),
        fontSize = 16.sp,
        style = TextStyle(
            textAlign = TextAlign.Center
        )
    )
}

