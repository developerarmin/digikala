package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_TOKEN
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NextShoppingList(
    navController: NavController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val nextCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }
    LaunchedEffect(true) {
        viewModel.nextCartItems.collectLatest { list ->
            nextCartItems.value = list
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .padding(bottom = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            item {
                if (USER_TOKEN == "null" || USER_TOKEN.isEmpty()) {
                    LoginOrRegisterState(navController)
                }
            }
            if (nextCartItems.value.isEmpty()) {
                item {
                    Column {
                        EmptyNextShoppingList()
                    }
                }
            } else {
                items(nextCartItems.value) { item ->
                    NextCartItemCard(item = item, changeStatus = { id, newStatus ->
                        viewModel.changeStatusCart(id, newStatus)
                    }, removeFromCart = {
                        viewModel.removeFromCart(it)
                    })
                }
            }
        }
    }
}