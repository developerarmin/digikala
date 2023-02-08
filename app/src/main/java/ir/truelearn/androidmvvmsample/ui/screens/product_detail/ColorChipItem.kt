package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.truelearn.androidmvvmsample.data.model.category.CategoryItemColor
import ir.truelearn.androidmvvmsample.ui.theme.CursorColor
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColorChipItem(
    name: String ,
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
    color: Long
) {
        Surface(
            modifier = if (isSelected) Modifier.padding(4.dp).border(width = 1.dp,MaterialTheme.colors.CursorColor,
                CircleShape) else Modifier.padding(4.dp),
            elevation = 1.dp,
            shape = RoundedCornerShape(20.dp),
            color = if (isSelected) Color.White else Color.White,
        ) {
            Row(modifier = Modifier
                .toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectionChanged(name)
                    }
                ).padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                    Canvas(
                        modifier = Modifier
                            .size(20.dp)
                            .border(1.dp, Color.Gray, CircleShape),
                        onDraw = {
                            drawCircle(Color(color))
                        }
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                    Text(text = name, fontSize = 12.sp)

            }
        }

}





