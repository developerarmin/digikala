package ir.truelearn.androidmvvmsample.ui.screens.home.search

import android.annotation.SuppressLint
import android.util.Log

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult

import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.LocalSpacing

import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ItemFoundBySearch(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var listFound by remember { mutableStateOf<List<SearchProductsModel>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }
    val searchingResult by viewModel.searching.collectAsState()
    when (searchingResult) {
        is NetworkResult.Success -> {
            listFound = searchingResult.data ?: emptyList()
            loading = false
            showSearchResult.value = true
        }
        is NetworkResult.Error -> {
            loading = false
            Log.d("5555", "Searching Error:${searchingResult.message} ")
        }

        is NetworkResult.Loading -> {
            loading = true
        }

    }

    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        var imgProduct by remember { mutableStateOf("") }
        var nameProduct by remember { mutableStateOf("") }

        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(LocalSpacing.current.mediumTwo),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = false)
            }
        } else {
            viewModel.searching.value.data?.size?.let { size ->
                for (i in viewModel.searching.value.data?.indices!!) {
                    imgProduct = viewModel.searching.value.data?.get(i)?.image.toString()
                    nameProduct = viewModel.searching.value.data?.get(i)?.name.toString()
                }

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = imgProduct)
                        .apply(block = fun ImageRequest.Builder.() { scale(Scale.FILL) })
                        .build()
                )


                val countFind = if (size <= 5) size else 5
                for (i in 1..countFind) {
                    LazyRow(
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                    ) {
                        items(countFind) {
                            SearchItem(
                                nameProduct = nameProduct,
                                painter = painter,
                                navController = navController,
                                item = listFound[i - 1]
                            )
                        }

                    }
                }
            }
        }
    }


}


/*
Card(modifier = Modifier.height(100.dp)) {

    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(data = imgProduct)
            .apply(block = fun ImageRequest.Builder.() { scale(Scale.FILL) })
            .build()
    )

    LazyRow(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.Center) {
        items(3){
            Image(painter = painter, contentDescription = "")
            Text(text = nameProduct)
        }
    }
}*/
