package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NextShoppingList() {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()

                .align(Alignment.TopCenter)
        ) {
                if (true)
                    LoginOrRegisterState()
            }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {

            if (true)
                EmptyNextShoppingList()
        }


        }

}