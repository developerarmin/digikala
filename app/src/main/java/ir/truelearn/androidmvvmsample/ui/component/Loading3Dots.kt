package ir.truelearn.androidmvvmsample.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.truelearn.androidmvvmsample.R

@Composable
fun Loading3Dots(isDark: Boolean) {
    if (isDark) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading3dotsdark))
        LottieAnimation(
            composition,
            iterations = LottieConstants.IterateForever
        )
    } else {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading3dots))
        LottieAnimation(
            composition,
            iterations = LottieConstants.IterateForever
        )
    }

}

