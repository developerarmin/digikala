package ir.truelearn.androidmvvmsample.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val miniDp : Dp = 0.5.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val mediumTwo: Dp = 20.dp,
    val semiLarge : Dp = 24.dp,
    val semiLargeTwo : Dp = 28.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
    val superLarge : Dp = 128.dp,
    val bottomAppBar: Dp = 60.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current