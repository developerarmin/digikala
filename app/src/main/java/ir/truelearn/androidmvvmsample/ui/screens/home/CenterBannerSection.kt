package ir.truelearn.androidmvvmsample.ui.screens.home

import android.util.Log
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.model.home.CenterBannerItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun CenterBannerItem(
    bannerNumber:Int,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var centerBanners by remember {
        mutableStateOf<List<CenterBannerItem>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        viewModel.centerBannerItems.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    withContext(Dispatchers.Main) {
                        centerBanners = result.data!!
                        loading = false
                    }
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("3636", "InitBanner error:${result.message} ")
                    // show error message
                }
                is NetworkResult.Loading -> {

                    withContext(Dispatchers.Main) {
                        loading = true
                    }
                }

                else -> {}
            }
        }
    }


    if (centerBanners.isNotEmpty()){

        CenterBannerItem(imageUrl = centerBanners[bannerNumber].image)

    }

   

}