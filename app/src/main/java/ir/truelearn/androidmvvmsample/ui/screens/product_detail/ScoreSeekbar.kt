package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ir.truelearn.androidmvvmsample.ui.theme.*

@Composable
fun ScoreSeekbar() {

    var sliderValue by remember {
        mutableStateOf(0f)
    }

    var score = sliderValue.toString()
    when (sliderValue.toInt()) {
        1 -> score = ""
        2 -> score = "خیلی بد"
        3 -> score = "بد"
        4 -> score = "معمولی"
        5 -> score = "خوب"
        6 -> score = "عالی"
        else -> {
            score = ""
        }
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MaterialTheme.spacing.small),
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.darkText,
        text = score,
        textAlign = TextAlign.Center
    )


    Slider(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.large),
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },

        valueRange = 1f..6f,
        steps = 4,
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colors.amber,
            activeTrackColor = MaterialTheme.colors.amber,
            inactiveTrackColor = MaterialTheme.colors.grayCategory,
            activeTickColor = MaterialTheme.colors.amber,
            inactiveTickColor = MaterialTheme.colors.grayAlpha
        ),

        )

}