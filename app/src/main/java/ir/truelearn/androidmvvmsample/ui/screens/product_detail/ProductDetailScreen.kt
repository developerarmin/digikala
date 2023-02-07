package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.gson.Gson
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.screens.home.Home
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightRed
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.util.DigitHelper.digitByLocate
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import ir.truelearn.androidmvvmsample.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetailScreen(navController: NavHostController, id: String,isAmazing:Boolean,item:AmazingItem,) {
    ProductDetail(navController, id,isAmazing, item = item)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductDetail(
    navController: NavHostController,
    id: String,
    isAmazing:Boolean,
    item:AmazingItem,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        viewModel.getAllDataFromServer()
    }

    if (!isSystemInDarkTheme()) {
        Scaffold(
            bottomBar = {
                BottomBarProductDetail(navController)
            },
        ){
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(bottom = 60.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                TopAppBarProductDetail(navController)
                ShowIsAmazing(isAmazing = isAmazing)
                //فعلا منظر api هستیم برای  همین از یه api دیگه برای اسلایدر استفاده کردم موقتا ....
                TopSliderProduct(item.image)
                ProductDetailHeader(item.name,"در دسته مد و پوشاک")
                SellerInfoDetails()
                ProductDetailCard()
                CommentsPreview()
                SimilarProductSection()
                RecommendedSimilarProductsSection()

            }
        }

    }
}

