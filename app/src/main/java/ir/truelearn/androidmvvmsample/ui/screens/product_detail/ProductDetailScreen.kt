package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.data.model.comment.CommentResponse
import ir.truelearn.androidmvvmsample.data.model.product_detail.ColorProductDetail
import ir.truelearn.androidmvvmsample.data.model.product_detail.ImageSlider
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.data.model.product_detail.SimilarProduct
import ir.truelearn.androidmvvmsample.data.model.profile.FavItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.screens.comment.CommentsPreview
import ir.truelearn.androidmvvmsample.ui.screens.comment.WriteCommentView
import ir.truelearn.androidmvvmsample.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    id: String,
    isAmazing: Boolean,
    productDetailItemPrice: Int,
    productDiscountPercent: Int
) {
    ProductDetail(navController, id ,isAmazing, productDetailItemPrice, productDiscountPercent)
}

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductDetail(
    navController: NavHostController,
    id: String,
    isAmazing: Boolean,
    productDetailItemPrice: Int,
    productDiscountPercent: Int,
    viewModel: ProductDetailViewModel = hiltViewModel(),

    ) {


    var item by remember {
        mutableStateOf<ProductDetailModel>(
            ProductDetailModel(
                "",
                "",
                "",
                "",
                "",
                0,
                "",
                0,
                1.0,
                0,
                0,
                0,
                0,
                0,
                0,
                listOf(ColorProductDetail("", "", "")),
                listOf(
                    CommentResponse("", "", "", "", "","","","")
                ),
                listOf(ImageSlider("", "", "")),

            )
        )
    }

    var imageSliders by remember {
        mutableStateOf<List<ImageSlider>>(emptyList())
    }

    var colors by remember {
        mutableStateOf<List<ColorProductDetail>>(emptyList())
    }

    var comments by remember {
        mutableStateOf<List<CommentResponse>>(emptyList())
    }

    var similarProduct by remember {
        mutableStateOf<List<SimilarProduct>>(emptyList())
    }

    var loading by remember { mutableStateOf(false) }

    LaunchedEffect(Dispatchers.IO) {
        viewModel.getAllDataFromServer(id)
        withContext(Dispatchers.Main) {
            viewModel.productDetail.collectLatest { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        result.data?.let {
                            item = it
                            imageSliders = it.imageSlider
                            colors = item.colors
                            comments = item.comments
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
    }

if (item.categoryId.isNotEmpty()){
    LaunchedEffect(Dispatchers.IO) {
        viewModel.getSimilarProducts(item.categoryId)
        withContext(Dispatchers.Main) {
            viewModel.similarProducts.collectLatest { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        result.data?.let {
                            similarProduct = it
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
    }

}



    if (!isSystemInDarkTheme()) {
        Scaffold(
            bottomBar = {
                BottomBarProductDetail(
                    itemPrice = productDetailItemPrice,
                    itemDiscount = productDiscountPercent,
                    navController,
                    item
                )
            },
        ) {

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(bottom = 60.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                TopAppBarProductDetail(
                    FavItem(
                        id,
                        item.discountPercent,
                        item.imageSlider[0].image,
                        item.name,
                        item.price,
                        item.seller,
                        item.star
                    ), navController
                )


                ShowIsAmazing(isAmazing = isAmazing)

                TopSliderProduct(imageSliders)

                ProductDetailHeader(item)

                ColorCategorySection(item.colors)

                SellerInfoDetails(item)

                ProductDetailCard()

                CommentsPreview(comments, item.commentCount)

                WriteCommentView(
                    image = item.imageSlider[0].image,
                    name = item.name ,
                    navController = navController,
                    id = item._id)

                DigiPlusCard()

                SimilarProductSection()

                RecommendedSimilarProductsSection()

            }
        }

    }
}

