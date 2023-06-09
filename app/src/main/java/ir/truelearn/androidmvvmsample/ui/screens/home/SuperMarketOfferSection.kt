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
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightGreen
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun SuperMarketOfferSection(
    navHostController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var list by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Dispatchers.Main) {

        viewModel.superMarketItems.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        list = it
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("3636", "InitSuperMarketItems error:${result.message} ")
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
            .background(MaterialTheme.colors.DigikalaLightGreen)
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
            LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightGreen)) {
                item {
                    AmazingOfferCard(R.drawable.supermarketamazings, R.drawable.fresh)
                }
                items(list) { item ->
                    AmazingItem(item, navHostController = navHostController, isAmazing = false)
                }
                item {
                    AmazingShowMoreItem()
                }
            }
        }

    }
}