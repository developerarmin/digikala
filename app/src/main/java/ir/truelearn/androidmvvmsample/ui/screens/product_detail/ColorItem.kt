package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import ir.truelearn.androidmvvmsample.data.model.category.CategoryItemColor
import ir.truelearn.androidmvvmsample.data.model.category.ColorCategory
import ir.truelearn.androidmvvmsample.ui.theme.CursorColor
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColorItem(name: String, color: CategoryItemColor) {
    val colors = when (color) {
        CategoryItemColor.BLUE -> Color(0xFF0000FF)
        CategoryItemColor.WHITE -> Color(0xFFFFFFFF)
        CategoryItemColor.GRAY -> Color(0xFF999999)
        CategoryItemColor.BLACK -> Color(0xFF000000)
    }
    var selected by remember {
        mutableStateOf(false)
    }

    if (selected) {
        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            colors = ChipDefaults.filterChipColors(
                backgroundColor = Color.White,
                selectedBackgroundColor = Color.White
            ),
            modifier = Modifier
                .border(1.dp, MaterialTheme.colors.CursorColor, CircleShape)
                .height(35.dp)
        ) {
            Row() {
                Canvas(
                    modifier = Modifier
                        .size(20.dp)
                        .border(1.dp, Color.Gray, CircleShape),
                    onDraw = {
                        drawCircle(colors)
                    }
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                Text(text = name)


            }
        }
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
    } else {
        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            colors = ChipDefaults.filterChipColors(
                backgroundColor = Color.White,
                selectedBackgroundColor = Color.White
            ),
            modifier = Modifier.height(35.dp)
        ) {
            Row() {
                Canvas(
                    modifier = Modifier
                        .size(20.dp)
                        .border(1.dp, Color.Gray, CircleShape),
                    onDraw = {
                        drawCircle(colors)
                    }
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                Text(text = name)

            }
        }
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
    }
}

