package ir.truelearn.androidmvvmsample.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.CircularCategoryItem
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun CategoryListSection(
    viewModel: HomeViewModel = hiltViewModel()

) {
    var list by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {

        viewModel.categories.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    withContext(Dispatchers.Main) {
                        list = result.data!!
                        loading = false
                    }
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("3636", "InitAmazingItems error:${result.message} ")
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


    val categoryTitle = stringResource(id = R.string.category_title)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .padding(MaterialTheme.spacing.small),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium),
            text = categoryTitle,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
        )

        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = false)
            }
        } else {

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                items(list) { item ->
                    CircularCategoryItem(item)
                }

            }


        }


    }

}