package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SuggestListSection(viewModel: CartViewModel = hiltViewModel()) {

    var suggestedList by remember {
        mutableStateOf<List<MostDiscountedItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Dispatchers.Main) {
        viewModel.getSuggestedList()
        viewModel.suggestedList.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        suggestedList = it
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false

                }

                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .background(MaterialTheme.colors.searchBarBg)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(680.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small),
            text = stringResource(id = R.string.suggestion_for_youSection),
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
        )

        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.searchBarBg)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = false)
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {

                items(suggestedList) { item ->
                    SuggestionForYouCard(item = item) {
                        viewModel.addNewItem(
                            CartItem(
                                item.Id,
                                item.discountPercent,
                                item.image,
                                item.name,
                                item.price,
                                item.seller,
                                1,
                                CartStatus.CURRENT_CART
                            )
                        )
                    }
                }


            }

        }
    }
}