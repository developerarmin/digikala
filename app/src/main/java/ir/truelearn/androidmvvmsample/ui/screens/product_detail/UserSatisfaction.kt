package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow


fun calculateSatisfactionPercentage(starCount: Double): Double = starCount / 5 * 100



@Composable
fun showSatisfactionGrade(percentage: Double): String {
    var grade by remember { mutableStateOf("") }

    if (percentage in 70.0..100.0) {

        grade = Text(
            text = "عالی",
            color = Color.Green,
            style = MaterialTheme.typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        ).toString()


    } else if (percentage in 40.0..69.0) {

        grade = Text(
            text = "متوسط",
            color = Color.Cyan,
            style = MaterialTheme.typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        ).toString()


    } else {
        grade = Text(
            text = "بد",
            color = Color.Red,
            style = MaterialTheme.typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        ).toString()


    }
    return grade
}