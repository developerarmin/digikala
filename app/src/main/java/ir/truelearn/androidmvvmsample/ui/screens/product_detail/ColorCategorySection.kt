package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.data.model.category.CategoryItemColor
import ir.truelearn.androidmvvmsample.data.model.category.ColorCategory
import ir.truelearn.androidmvvmsample.ui.theme.CursorColor
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ColorCategorySection() {
    val list = listOf<ColorCategory>(
        ColorCategory("مشکی", CategoryItemColor.BLACK),
        ColorCategory("سفید", CategoryItemColor.WHITE),
        ColorCategory("خاکستری", CategoryItemColor.GRAY),
        ColorCategory("آبی", CategoryItemColor.BLUE)
    )
    var color = remember {
        mutableStateOf("مشکی")
    }

    Column() {
        Text(
            text = " رنگ: ${color.value}",
            color = MaterialTheme.colors.darkText,
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
        FlowRow(
            maxItemsInEachRow = 10, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = MaterialTheme.spacing.small)
        ) {
            list.forEach {
                 ColorItem(name = it.name, color =it.color )
            }
        }
    }
}