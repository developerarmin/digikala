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
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.product_detail.ColorProductDetail
import ir.truelearn.androidmvvmsample.data.model.product_detail.Comment
import ir.truelearn.androidmvvmsample.data.model.product_detail.ImageSlider
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    id: String,
    isAmazing: Boolean,
    productDetailItemPrice : Int
) {
    ProductDetail(navController,id,isAmazing,productDetailItemPrice)
}

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductDetail(
    navController: NavHostController,
    id: String,
    isAmazing: Boolean,
    productDetailItemPrice : Int,
    viewModel: ProductDetailViewModel = hiltViewModel(),

) {



    LaunchedEffect(true) {
        viewModel.getAllDataFromServer(id)
    }





    if (!isSystemInDarkTheme()) {
        Scaffold(
            bottomBar = {
                BottomBarProductDetail(itemPrice = productDetailItemPrice,navController)
            },
        ) {

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(bottom = 60.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                TopAppBarProductDetail(navController)

                ShowIsAmazing(isAmazing = isAmazing)

                //section
                ProductDetailSection()
                DigiPlusCard()
                SimilarProductSection()

                RecommendedSimilarProductsSection()

            }
        }

    }
}

