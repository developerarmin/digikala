package ir.truelearn.androidmvvmsample.ui.screens.category

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.category.Sub
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.screens.category.popularBrands.TheMostPopularBrands
import ir.truelearn.androidmvvmsample.viewmodel.CategoryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

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

    LaunchedEffect(Dispatchers.Main) {

        viewModel.subCategory.collectLatest { result ->
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
                    Log.d("2121", "InitSubCategory error:${result.message} ")
                }
                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (loading)
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = true)
            }
        }
        else
        {

            CategoryItem(
                title = stringResource(id = R.string.industrial_tools_and_equipment),
                subList = toolList
            )
            CategoryItem(
                title = stringResource(id = R.string.digital_goods),
                subList = digitalList
            )
            CategoryItem(
                title = stringResource(id = R.string.mobile),
                subList = mobileList
            )
            CategoryItem(
                title = stringResource(id = R.string.fashion_and_clothing),
                subList = fashionList
            )
            CategoryItem(
                title = stringResource(id = R.string.supermarket_product),
                subList = supermarketList
            )
            CategoryItem(
                title = stringResource(id = R.string.native_and_local_products),
                subList = nativeList
            )
            CategoryItem(
                title = stringResource(id = R.string.toys_children_and_babies),
                subList = toyList
            )
            CategoryItem(
                title = stringResource(id = R.string.beauty_and_health),
                subList = beautyList
            )
            CategoryItem(
                title = stringResource(id = R.string.home_and_kitchen),
                subList = homeList
            )
            CategoryItem(
                title = stringResource(id = R.string.books_and_stationery),
                subList = bookList
            )
            CategoryItem(
                title = stringResource(id = R.string.sports_and_travel),
                subList = sportList
            )
                TheMostPopularBrands()
        }
    }


}

