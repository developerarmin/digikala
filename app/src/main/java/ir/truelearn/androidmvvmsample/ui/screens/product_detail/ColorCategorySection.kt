package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.data.model.category.CategoryItemColor
import ir.truelearn.androidmvvmsample.data.model.category.ColorCategory
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing

val list = listOf<ColorCategory>(
    ColorCategory("مشکی", 0xFF000000),
    ColorCategory("سفید", 0xFFFFFFFF),
    ColorCategory("خاکستری", 0xFF999999),
    ColorCategory("آبی", 0xFF0000FF)
)

val selectedColorItem: MutableState<ColorCategory?> = mutableStateOf(null)

@Composable

fun ColorCategorySection(
    items: List<ColorCategory> = list,
    onSelectedChanged: (String) -> Unit = { name ->
        list.forEach {
            if (it.name == name) {
                selectedColorItem.value = it
            }
        }
    }
) {

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = " رنگ: ${if (selectedColorItem.value?.name == null) "انتخاب نشده" else selectedColorItem.value?.name}",
            color = MaterialTheme.colors.darkText,
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(items) {
                ColorChipItem(
                    name = it.name,
                    isSelected = selectedColorItem.value?.color == it.color,
                    onSelectionChanged = {
                        onSelectedChanged(it)
                    },
                    color = it.color
                )
            }
        }
    }
}

/* FlowRow(
     maxItemsInEachRow = 10, modifier = Modifier
         .fillMaxWidth()
         .wrapContentHeight()
         .padding(horizontal = MaterialTheme.spacing.small)
 ) {
     list.forEach {
          Chipp(name = it.name, color =it.color )
     }
 }*/

