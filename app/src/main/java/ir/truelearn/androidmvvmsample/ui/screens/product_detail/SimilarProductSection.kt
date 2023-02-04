package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.FavoriteProduct
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.DarkCyan
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun SimilarProductSection(viewModel: ProductDetailViewModel = hiltViewModel()){
    var list by remember { mutableStateOf<List<FavoriteProduct>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        viewModel.similarProducts.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    withContext(Dispatchers.Main) {
                        result.data?.let {
                            list = it
                        }
                        loading = false
                    }
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.e("5555", "MyProduct error:${result.message} ")
                }
                is NetworkResult.Loading -> {
                    withContext(Dispatchers.Main) {
                        loading = true
                    }
                }
            }
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(MaterialTheme.spacing.small)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Text(
                modifier = Modifier.padding(top = 4.dp, start = 4.dp),
                text = stringResource(id = R.string.similar_product),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.DarkCyan,
                fontSize = 13.sp)
        }

        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = false)
            }
        }else{
            LazyRow{
                items(list) { item ->
                    SimilarProduct(item)
                }
            }
        }
    }
}