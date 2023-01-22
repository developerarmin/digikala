package ir.truelearn.androidmvvmsample.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun ProposalCardSection(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var listProposal by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        viewModel.banners.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    withContext(Dispatchers.Main) {
                        listProposal = result.data!!
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
            }
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth().height(290.dp).padding(8.dp)
    ){
        items(listProposal){ item->
            ProposalCardItem(item)
        }

    }

}