package ir.truelearn.androidmvvmsample.ui.screens.category

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.model.category.Sub
import ir.truelearn.androidmvvmsample.data.model.category.SubCategory
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.viewmodel.CategoryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun SubCategorySection(viewModel: CategoryViewModel = hiltViewModel()) {

    var beautyList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var bookList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var digitalList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var fashionList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var homeList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var mobileList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var nativeList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var sportList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var supermarketList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var toolList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var toyList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true) {

        viewModel.subCategory.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    withContext(Dispatchers.Main) {
                        beautyList = result.data!!.beauty
                        bookList = result.data.book
                        digitalList = result.data.digital
                        fashionList = result.data.fashion
                        homeList = result.data.home
                        mobileList = result.data.mobile
                        nativeList = result.data.native
                        sportList = result.data.sport
                        supermarketList = result.data.supermarket
                        toolList = result.data.tool
                        toyList = result.data.toy
                        loading = false
                    }
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("2121", "InitSubCategory error:${result.message} ")
                    // show error message
                }
                is NetworkResult.Loading -> {
                    withContext(Dispatchers.Main) {
                        loading = true
                    }
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots()
            }
        } else {
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(toolList) { tool ->
                    SubCategoryItem(tool)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(digitalList) { digital ->
                    SubCategoryItem(digital)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(mobileList) { mobile ->
                    SubCategoryItem(mobile)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(fashionList) { fashion ->
                    SubCategoryItem(fashion)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(supermarketList) { supermarket ->
                    SubCategoryItem(supermarket)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(nativeList) { native ->
                    SubCategoryItem(native)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(toyList) { toy ->
                    SubCategoryItem(toy)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(beautyList) { beauty ->
                    SubCategoryItem(beauty)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(homeList) { home ->
                    SubCategoryItem(home)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(bookList) { book ->
                    SubCategoryItem(book)
                }
            }
            LazyRow(modifier = Modifier.background(Color.White)) {
                items(sportList) { sport ->
                    SubCategoryItem(sport)
                }
            }

        }

    }


}

