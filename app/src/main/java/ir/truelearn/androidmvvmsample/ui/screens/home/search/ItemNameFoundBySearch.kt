package ir.truelearn.androidmvvmsample.ui.screens.home.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen

import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.LocalSpacing
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.spacing

import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ItemNameFoundBySearch(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var nameFound by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }

    val nameSearchingResult by viewModel.searching.collectAsState()

    when (nameSearchingResult) {
        is NetworkResult.Success -> {
            nameFound = nameSearchingResult.data.toString()
            loading = false
            showSearchResult.value = true
        }
        is NetworkResult.Error -> {
            loading = false
            Log.d("5555", "Searching Error:${nameSearchingResult.message} ")
        }

        is NetworkResult.Loading -> {
            loading = true
        }

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
            .clickable {
                navController.navigate(Screen.ProductListScreen.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            },
        horizontalArrangement = Arrangement.Start
    ) {

        var productName by remember {
            mutableStateOf("")
        }

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
                for (i in viewModel.searching.value.data?.indices!!) {
                    productName = viewModel.searching.value.data?.get(i)?.name.toString()
                }

                Image(
                    painter = painterResource(id = R.drawable.all_products_search_icon),
                    contentDescription = "all product search icon",
                    modifier = Modifier.size(35.dp)
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                Text(
                    text = stringResource(id = R.string.all_products_search_category)+" "+productName,
                    fontFamily = font_standard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.DarkGray,
                )

            }


        }


    }

}
