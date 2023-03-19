package ir.truelearn.androidmvvmsample.ui.screens.home.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.LocalSpacing
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ItemFoundBySearch(viewModel: HomeViewModel = hiltViewModel()) {
    var listFound by remember { mutableStateOf<List<SearchProductsModel>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }
    LaunchedEffect(Dispatchers.Main) {
        viewModel.searching.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let { listFound = it }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("5555", "Searching Error:${result.message} ")
                }

                is NetworkResult.Loading -> { loading = true }
            }
        }
    }
    Row(modifier = Modifier.height(100.dp).fillMaxWidth()) {
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
                imgProduct = viewModel.searching.value.data?.get(0)?.img.toString()
                nameProduct = viewModel.searching.value.data?.get(0)?.name.toString()

                val countFind = if (size <= 5) size else 5
                for (i in 1..countFind) {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(0.5f)
                    ) {

                        val painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(data = imgProduct)
                                .apply(block = fun ImageRequest.Builder.() { scale(Scale.FILL) })
                                .build()
                        )

                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(painter = painter, contentDescription = "")
                            Text(text = nameProduct)
                        }
                    }
                }
            }
        }
    }
}