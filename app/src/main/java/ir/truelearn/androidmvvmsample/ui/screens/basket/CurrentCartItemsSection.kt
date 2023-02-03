package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CurrentCartItemsSection(viewModel: CartViewModel = hiltViewModel()) {
    val currentCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }

    LaunchedEffect(key1 = true) {
        viewModel.currentCartItems.collectLatest { list ->
            currentCartItems.value = list
        }
    }
    LazyColumn() {
        items(currentCartItems.value) { item ->

        }
    }
}