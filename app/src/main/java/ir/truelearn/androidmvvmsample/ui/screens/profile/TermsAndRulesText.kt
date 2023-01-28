package ir.truelearn.androidmvvmsample.ui.screens.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun TermsAndRulesText(
    fullText: String,
    textColor: Color,
    underlinedText: List<String>,
    underlinedTextFontWeight: FontWeight = FontWeight.Medium,
    underlinedTextDecoration: TextDecoration = TextDecoration.Underline,
    fontSize: TextUnit,
    textAlign: TextAlign
) {

    Text(
        text = buildAnnotatedString {
            append(fullText)
            underlinedText.forEachIndexed { index, text ->
                val startIndex = fullText.indexOf(text)
                val endIndex = startIndex + text.length

                addStyle(
                    style = SpanStyle(
                        fontSize = fontSize,
                        fontWeight = underlinedTextFontWeight,
                        textDecoration = underlinedTextDecoration
                    ), start = startIndex, end = endIndex
                )
                addStyle(
                    style = SpanStyle(
                        fontSize = fontSize,
                        fontFamily = font_standard,
                        color = textColor,
                    ),
                    start = 0, end = fullText.length
                )
            }
        },
        modifier = Modifier.padding(
            horizontal = MaterialTheme.spacing.small,
            vertical = MaterialTheme.spacing.medium
        ),
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,

        )


}