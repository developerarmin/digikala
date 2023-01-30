package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NextShoppingList() {

    Box(
        modifier = Modifier
//            .background(Color.Blue)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            if(true)
            LoginOrRegisterState()
            if(true)
            EmptyNextShoppingList()
        }
    }
}