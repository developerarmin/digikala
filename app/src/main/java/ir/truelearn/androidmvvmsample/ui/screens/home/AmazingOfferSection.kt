package ir.truelearn.androidmvvmsample.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightRed
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun AmazingOfferSection(
    viewModel: HomeViewModel = hiltViewModel(),
    navHostController: NavController
) {
    var list by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Dispatchers.Main) {

        viewModel.amazingItems.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        list = it
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("2121", "InitAmazingItems error:${result.message} ")
                    // show error message
                }
                is NetworkResult.Loading -> {
                    loading = true
                }

                else -> {}
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.DigikalaLightRed)
    ) {
        //Spacer(modifier = Modifier.weight(1f))
        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = false)
            }
        } else {
            LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightRed)) {
                item {
                    AmazingOfferCard(R.drawable.amazings, R.drawable.box)
                }
                items(list) { item ->
                    AmazingItem(item = item, navHostController = navHostController, isAmazing = true)
                }
                item {
                    AmazingShowMoreItem()
                }
            }
        }

    }
}