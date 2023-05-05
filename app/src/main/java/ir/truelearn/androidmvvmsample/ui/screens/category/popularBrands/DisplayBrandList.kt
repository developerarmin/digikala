package ir.truelearn.androidmvvmsample.ui.screens.category.popularBrands

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.ui.theme.BrandListItem

@Composable
fun DisplayBrandsList(list: List<String>, action: (String) -> Unit) {
    var selectedItem by remember {
        mutableStateOf(list[0])
    }
    LazyRow() {
        items(list) { item ->
            OutlinedButton(
                onClick = {
                    selectedItem = item
                    action(item)
                },
                shape = RoundedCornerShape(32.dp),
                border = if (selectedItem == item) BorderStroke(1.dp, Color.Red)
                else BorderStroke(1.dp, Color(0xFFEDEDED))
            ) {
                Text(
                    text = item,
                    color = if (selectedItem == item) Color.Red
                    else Color.Black,
                    style = MaterialTheme.typography.BrandListItem
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}