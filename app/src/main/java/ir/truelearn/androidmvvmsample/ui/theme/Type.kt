package ir.truelearn.androidmvvmsample.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.R

val font_medium = FontFamily(
    Font(R.font.iranyekanmedium)
)
val font_bold = FontFamily(
    Font(R.font.iranyekanbold)
)
val font_standard = FontFamily(
    Font(R.font.iranyekan)
)

val Typography.extraBoldNumber: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font_bold,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    )

val Typography.underlinedText : TextStyle
@Composable
get() = TextStyle(
    fontFamily = font_standard,
    fontWeight = FontWeight.Medium,
    textDecoration = TextDecoration.Underline
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = font_medium,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    body2 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 26.sp
    ),

    h1 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 26.sp
    ),
    h2 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 26.sp
    ),
    h3 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    h4 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 26.sp
    ),
    h5 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 26.sp
    ),
    h6 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 26.sp
    ),
)
val SmallFont = Typography(
    body1 = TextStyle(
        fontFamily = font_standard,
        fontSize = 11.sp,
        lineHeight = 26.sp
    )
)

//MostPopularBrands Title Style
val Typography.MostPopularBrandsTitle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font_bold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp
    )

//BrandList Item Style
val Typography.BrandListItem: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font_medium,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    )

//CartReceiveInPersonAddress
val Typography.CartReceive: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Light,
        fontSize = 13.sp,
    )