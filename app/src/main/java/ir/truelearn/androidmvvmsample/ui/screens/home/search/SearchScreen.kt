package ir.truelearn.androidmvvmsample.ui.screens.home


import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.ui.screens.home.search.AllProductsSearch
import ir.truelearn.androidmvvmsample.ui.screens.home.search.HotProductSearch
import ir.truelearn.androidmvvmsample.ui.screens.home.search.ItemFoundBySearch
import ir.truelearn.androidmvvmsample.ui.theme.spacing


@Composable
fun SearchScreen(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize()) {
        SearchScreenTextField(navController)
        Spacer(modifier = androidx.compose.ui.Modifier.height(MaterialTheme.spacing.medium))


        if (showSearchResult.value){
            ItemFoundBySearch(navController)
            AllProductsSearch(productName = "", navController = navController)

        } else {
            HotProductSearch()
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            OnlineShoppingAdviceCard()
        }





    }
}


