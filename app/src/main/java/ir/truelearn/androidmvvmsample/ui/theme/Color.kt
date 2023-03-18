package ir.truelearn.androidmvvmsample.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFed1b34)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val DarkAmper = Color(0xFFFFA200)
val infoBox = Color(0xFFEDEEF1)
val BtnWhite = Color(0xFFFBFBFC)
val textFieldBG = Color(0xFFCECED2)

val cardCollapsedBackgroundColor = Color(0xFFFEFFFD)
val cardExpandedBackgroundColor = Color(0xFFFFDA6D)





val Colors.selectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFF43474C) else Color(0xFFCFD4DA)

val Colors.unSelectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFFA4A1A1) else Color(0xFF575A5E)

val Colors.splashBg: Color
    @Composable
    get() = Color(0xFFed1b34)

val Colors.searchBarBg: Color
    @Composable
    get() = if (isLight) Color(0xFFF1F0EE) else Color(0xFF303235)

val Colors.darkText: Color
    @Composable
    get() = if (isLight) Color(0xFF414244) else Color(0xFFD8D8D8)

val Colors.semiDarkText: Color
    @Composable
    get() = if (isLight) Color(0xFF5C5E61) else Color(0xFFD8D8D8)

val Colors.digikalaRed: Color
    @Composable
    get() = Color(0xFFed1b34)

val Colors.DigikalaLightRed: Color
    @Composable
    get() = Color(0xffef4056)

val Colors.DigikalaDarkRed: Color
    @Composable
    get() = Color(0xFFe6123d)

val Colors.DarkCyan: Color
    @Composable
    get() = Color(0xFF0fabc6)

val Colors.LightCyan: Color
    @Composable
    get() = Color(0xFF00BECB)

val Colors.grayCategory: Color
    @Composable
    get() = Color(0xFFF1F0EE)
val Colors.grayAlpha: Color
    @Composable
    get() = Color(0xFFc1c2c6)

val Colors.DigikalaLightGreen: Color
    @Composable
    get() = Color(0xff86bf3c)

val Colors.amber: Color
    @Composable
    get() = Color(0xffFFBF00)

val Colors.DigikalaInStock : Color
   @Composable
   get() = Color(0xFF1C9CB5)

val Colors.CursorColor : Color
   @Composable
   get() = Color(0xFF018577)
val Colors.Gold : Color
   @Composable
   get() = Color(0xFFf9bc01)

val Colors.TruckDeliveryIcon : Color
    @Composable
    get() = Color(0xFF68AF47)

val Colors.PostTextColor : Color
    @Composable
    get() = Color(0xFFD8D8D8)

val Colors.RecommendedSimilarProductsTextColor : Color
    @Composable
    get() = Color(0xFF303235)

val Colors.Green : Color
    @Composable
    get() = Color(0xFF00A049)

val Colors.LightBlue : Color
    @Composable
    get() = Color(0xFF17BFD3)

val Colors.Orange : Color
    @Composable
    get() = Color(0xFFF57E16)

val Colors.Gray : Color
    @Composable
    get() = Color(0xFF9E9FB0)

val Colors.RedColor : Color
    @Composable
    get() = Color(0xFFb03857)
val Colors.CartCyan: Color
    @Composable
    get() = Color(0xFF339AF0)
val Colors.Purple: Color
    @Composable
    get() = Color(0xFF8b3e7a)