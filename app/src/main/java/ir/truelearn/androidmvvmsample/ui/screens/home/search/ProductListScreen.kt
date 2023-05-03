package ir.truelearn.androidmvvmsample.ui.screens.home.search

import android.annotation.SuppressLint
import android.widget.GridLayout.Spec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.screens.category.SpecialSaleCard
import ir.truelearn.androidmvvmsample.ui.screens.home.AmazingItem
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.viewmodel.ProductListViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductListScreen(
    searchValue: String ,
    navController: NavHostController,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val productList = viewModel.productList.collectAsLazyPagingItems()


    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {

            items(productList) { item ->
                if (item != null) {
                    SpecialSaleCard(item,navController)
                }
            }

            productList.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colors.searchBarBg)
                                    .padding(20.dp)
                                    .align(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Loading3Dots(isDark = false)
                            }
                        }
                    }
                    loadState.append is LoadState.Loading -> {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colors.digikalaRed)
                                    .padding(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Loading3Dots(isDark = false)
                            }
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        //todo error handling
                    }
                }
            }
        }
    }

}
