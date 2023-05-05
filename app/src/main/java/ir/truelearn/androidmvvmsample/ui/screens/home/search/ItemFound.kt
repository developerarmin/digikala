package ir.truelearn.androidmvvmsample.ui.screens.home.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ItemFound(item: SearchProductsModel, navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
//    val size = viewModel.searching.value.data?.size
    val imgProduct = item.image
    val nameProduct = item.name

    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(data = imgProduct)
            .apply(block = fun ImageRequest.Builder.() { scale(Scale.FILL) }).build())

    Card(modifier = Modifier.fillMaxWidth(0.7f).height(100.dp).clip(RoundedCornerShape(16.dp))) {
        SearchItem(
            nameProduct = nameProduct,
            painter = painter,
            navController = navController,
            item = item
        )
    }



//    Row(modifier = Modifier.height(100.dp).fillMaxWidth()) {
//
//        val painter = rememberAsyncImagePainter(
//            ImageRequest.Builder(LocalContext.current)
//                .data(data = imgProduct)
//                .apply(block = fun ImageRequest.Builder.() { scale(Scale.FILL) })
//                .build()
//                )


//        val countFind = if (size!! <= 5) size else 5
//        for (i in 1..countFind) {
//            LazyRow(
//                modifier = Modifier
//                    .height(200.dp)
//                    .fillMaxWidth()
//            ) {
//
//            }
//        }
//    }
}