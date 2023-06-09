package ir.truelearn.androidmvvmsample.ui.screens.home.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.theme.roundedShape

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchItem(
    nameProduct : String,
    painter:Painter,
    isAmazing:Boolean = true ,
    navController:NavHostController,
    item:SearchProductsModel
    ) {
    Card(
        modifier = Modifier
            .width(250.dp)
            .padding(8.dp)
        ,
        shape = MaterialTheme.roundedShape.small,
        onClick = {
            navController.navigate(Screen.ProductDetail.withArgs(item._id,isAmazing,item.price,item.discountPercent))

        }


    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically){
            val lineHeight = MaterialTheme.typography.h2.fontSize * 4/3
            //Spacer(modifier = Modifier.width(2.dp))
            Image(painter = painter, contentDescription = "",modifier = Modifier.weight(0.3f).padding(8.dp))

            Text(
                text = nameProduct,
                fontSize = 12.sp,
                lineHeight = lineHeight,
                modifier = Modifier.weight(0.7f)
            )


            Spacer(modifier = Modifier.width(2.dp))
        }
    }
}