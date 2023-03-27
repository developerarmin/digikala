package ir.truelearn.androidmvvmsample.ui.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.screens.category.SpecialSaleCard
import ir.truelearn.androidmvvmsample.viewmodel.ProductListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun ProductListScreen(
    searchValue: String,
    navController: NavHostController,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val productList = viewModel.productList.collectAsLazyPagingItems()
    LazyColumn(){
        items(productList){
            SpecialSaleCard()
        }
    }
    var list by remember {
        mutableStateOf<List<SearchProductsModel>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

//    LaunchedEffect(Dispatchers.IO){
//        viewModel.getAllDataFromServer(pageNumber,pageSize,searchValue)
//        withContext(Dispatchers.Main){
//            viewModel.productList.collectLatest { result ->
//                when (result){
//                    is NetworkResult.Success -> {
//                        result.data?.let {
//                            list = it
//                        }
//                        loading = false
//                    }
//                    is NetworkResult.Error -> {
//                        Log.e("3636","Data error : ${result.message}")
//                        loading = true
//                    }
//                    is NetworkResult.Loading -> {
//                        loading = true
//                    }
//                }
//
//            }
//        }
//    }

}