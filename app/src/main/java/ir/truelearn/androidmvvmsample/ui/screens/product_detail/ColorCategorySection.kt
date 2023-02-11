package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.util.Log
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
import androidx.core.graphics.toColorInt
import ir.truelearn.androidmvvmsample.data.model.category.CategoryItemColor
import ir.truelearn.androidmvvmsample.data.model.category.ColorCategory
import ir.truelearn.androidmvvmsample.data.model.product_detail.ColorProductDetail
import ir.truelearn.androidmvvmsample.data.model.product_detail.ImageSlider
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing


val selectedColorItem: MutableState<ColorProductDetail?> = mutableStateOf(null)

@Composable

fun ColorCategorySection(
    items: List<ColorProductDetail>,
    onSelectedChanged: (String) -> Unit = { name ->
        items.forEach {
            if (it.color == name) {
                selectedColorItem.value = it
            }
        }
    }
) {

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = " رنگ: ${if (selectedColorItem.value?.color == null) "انتخاب نشده" else selectedColorItem.value?.color}",
            color = MaterialTheme.colors.darkText,
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
        var colorState by remember {
            mutableStateOf<List<ColorProductDetail>>(listOf(ColorProductDetail("123","#ffffff","white")))
        }
        colorState = items
       // Log.e("3636",colorState[0].code.replace("#","0xFF"))
         LazyRow {
                items(colorState) {
                    ColorChipItem(
                        name = it.color,
                        isSelected = selectedColorItem.value?.color == it.color,
                        onSelectionChanged = {
                            onSelectedChanged(it)
                        },
                        color = it.code
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

