package ir.truelearn.androidmvvmsample.ui.screens.category.popularBrands


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.category.BrandsSub
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.theme.MostPopularBrandsTitle
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CategoryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

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


    val brandsList = listOf(
        getString(id = R.string.industrial_tools_and_equipment),
        getString(id = R.string.digital_goods),
        getString(id = R.string.mobile),
        getString(id = R.string.supermarket_product),
        getString(id = R.string.fashion_and_clothing),
        getString(id = R.string.native_and_local_products),
        getString(id = R.string.toys_children_and_babies),
        getString(id = R.string.beauty_and_health),
        getString(id = R.string.home_and_kitchen),
        getString(id = R.string.books_and_stationery),
        getString(id = R.string.sports_and_travel)
    )
    var selectedBrand by remember {
        mutableStateOf(brandsList[0])
    }

    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(MaterialTheme.spacing.medium)
        .background(MaterialTheme.colors.searchBarBg))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.medium)
    ) {
        Text(
            text = stringResource(id = R.string.the_most_popular_brands),
            style = MaterialTheme.typography.MostPopularBrandsTitle
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        DisplayBrandsList(brandsList) { brand ->
            selectedBrand = brand
        }
        when (selectedBrand) {
            getString(id = R.string.industrial_tools_and_equipment) -> DisplayBrandImages(toolList)
            getString(id = R.string.digital_goods) -> DisplayBrandImages(digitalList)
            getString(id = R.string.mobile) -> DisplayBrandImages(mobileList)
            getString(id = R.string.supermarket_product) -> DisplayBrandImages(supermarketList)
            getString(id = R.string.fashion_and_clothing) -> DisplayBrandImages(fashionList)
            getString(id = R.string.native_and_local_products) -> DisplayBrandImages(nativeList)
            getString(id = R.string.toys_children_and_babies) -> DisplayBrandImages(toyList)
            getString(id = R.string.beauty_and_health) -> DisplayBrandImages(beautyList)
            getString(id = R.string.home_and_kitchen) -> DisplayBrandImages(homeList)
            getString(id = R.string.books_and_stationery) -> DisplayBrandImages(bookList)
            getString(id = R.string.sports_and_travel) -> DisplayBrandImages(sportList)
        }

    }
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(MaterialTheme.spacing.medium)
        .background(MaterialTheme.colors.searchBarBg))
    Spacer(modifier = Modifier.height(60.dp))

}
@Composable
private fun getString(id: Int): String =
    stringResource(id = id)