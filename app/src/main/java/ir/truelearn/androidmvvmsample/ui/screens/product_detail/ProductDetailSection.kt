package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.model.product_detail.ColorProductDetail
import ir.truelearn.androidmvvmsample.data.model.product_detail.Comment
import ir.truelearn.androidmvvmsample.data.model.product_detail.ImageSlider
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProductDetailSection(
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    var item by remember {
        mutableStateOf<ProductDetailModel>(
            ProductDetailModel(
                "",
                0,
                0,
                listOf(ColorProductDetail("", "", "")),
                0,
                listOf(
                    Comment("", "", "", "", "")
                ),
                0,
                listOf(ImageSlider("", "", "")),
                "",
                0,
                0,
                "",
                1.0,
                0
            )
        )
    }

    var imageSliders by remember {
        mutableStateOf<List<ImageSlider>>(emptyList())
    }

    var colors by remember {
        mutableStateOf<List<ColorProductDetail>>(emptyList())
    }

    var loading by remember { mutableStateOf(false) }

    LaunchedEffect(Dispatchers.Main) {
        viewModel.productDetail.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        item = it
                        imageSliders = it.imageSlider
                        colors = item.colors
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("5555", "Data error:${result.message} ")
                }
                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.White)
            .fillMaxWidth()
    ) {
        TopSliderProduct(imageSliders)

        ProductDetailHeader(
            item.name,
            "در دسته مد و پوشاک",
            item.star,
            item.starCount,
            item.commentCount,
            item.questionCount
        )

        ColorCategorySection(item.colors)

        SellerInfoDetails(item)

        ProductDetailCard()

        CommentsPreview()

    }

}