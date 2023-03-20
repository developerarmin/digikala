package ir.truelearn.androidmvvmsample.ui.screens.category


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.category.BrandsCategory
import ir.truelearn.androidmvvmsample.data.model.category.BrandsSub
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.grayAlpha
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CategoryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)
@Composable
fun TheMostPopularBrands() {

    val viewModel: CategoryViewModel = hiltViewModel()

    var beautyList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var bookList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var digitalList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var fashionList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var homeList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var mobileList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var nativeList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var sportList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var supermarketList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var toolList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }
    var toyList by remember {
        mutableStateOf<List<BrandsSub>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        viewModel.getAllDataFromServer()
    }
    LaunchedEffect(Dispatchers.Main) {
        viewModel.brandsCategory.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        beautyList = it.beauty
                        bookList = it.book
                        digitalList = it.digital
                        fashionList = it.fashion
                        homeList = it.home
                        mobileList = it.mobile
                        nativeList = it.native
                        sportList = it.sport
                        supermarketList = it.supermarket
                        toolList = it.tool
                        toyList = it.toy
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                }
                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }


    var getClickedBrands by remember {
        mutableStateOf("ابزار و تجهیزات صنعتی")
    }
    val brandsList = listOf(
        "ابزار و تجهیزات صنعتی",
        "کالای دیجیتال",
        "موبایل",
        "کالای سوپرمارکت",
        "مد و پوشاک",
        "محصولات بومی و محلی",
        "اسباب بازی، کودک و نوجوان",
        "زیبایی و سلامت",
        "خانه و اشپزخانه",
        "کتاب و لوازم",
        "ورزش و سفر"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 60.dp),
    ) {
        Text(
            text = "محبوب ترین برندها"
        )

        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = false)
            }
        } else {

            setBrandsList(brandsList){
                getClickedBrands = it
            }
            when (getClickedBrands){
                "ابزار و تجهیزات صنعتی"-> setBrandsImages(toolList)
                "کالای دیجیتال"-> setBrandsImages(digitalList)
                "موبایل"-> setBrandsImages(mobileList)
                "کالای سوپرمارکت"-> setBrandsImages(supermarketList)
                "مد و پوشاک"-> setBrandsImages(fashionList)
                "محصولات بومی و محلی"-> setBrandsImages(nativeList)
                "اسباب بازی، کودک و نوجوان"-> setBrandsImages(toyList)
                "زیبایی و سلامت"-> setBrandsImages(beautyList)
                "خانه و اشپزخانه"-> setBrandsImages(homeList)
                "کتاب و لوازم"-> setBrandsImages(bookList)
                "ورزش و سفر"-> setBrandsImages(sportList)
            }
        }
    }
}


@Composable
fun setBrandsList(list: List<String>, action: (String) -> Unit) {
    var selectedIndex by remember {
        mutableStateOf(-1)
    }
    LazyRow() {
        items(list.size) { index ->
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(32.dp),
                border = if (selectedIndex == index) BorderStroke(1.dp, Color.Red)
                else BorderStroke(1.dp, Color(0xFFEDEDED))
            ) {
                Text(text = list[index],
                    modifier = Modifier
                        .selectable(
                            selected = selectedIndex == index,
                            onClick = {
                                selectedIndex = index
                                action(list[index])
                            }
                        ),
                    color = if (selectedIndex == index) Color.Red
                    else Color.Black)
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)
@Composable
fun setBrandsImages(list: List<BrandsSub>) {
    FlowRow(
        horizontalArrangement = Arrangement.SpaceAround,
        maxItemsInEachRow = 4,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (item in list) {
            Card(
                onClick = { /*TODO*/ },
                border = BorderStroke(width = 0.dp, color = MaterialTheme.colors.grayAlpha),
                shape = RectangleShape
            ) {
                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.medium
                        )
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}