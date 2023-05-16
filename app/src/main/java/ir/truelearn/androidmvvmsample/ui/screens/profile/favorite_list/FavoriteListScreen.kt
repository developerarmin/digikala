package ir.truelearn.androidmvvmsample.ui.screens.profile.favorite_list


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteListScreen(navController: NavHostController) {

    Scaffold(
        topBar = { FavoriteListTopAppBar(navController = navController) }
    ) { it ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(it)
        ) {
            FavoriteListSection(navController = navController)
        }


    }


}
