package ir.truelearn.androidmvvmsample.ui.screens.home.search


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.navigation.Screen
import ir.truelearn.androidmvvmsample.ui.screens.home.OnlineShoppingAdviceCard
import ir.truelearn.androidmvvmsample.ui.theme.CursorColor
import ir.truelearn.androidmvvmsample.ui.theme.DarkCyan
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch


@Composable
fun SearchScreen(navController: NavHostController) {
    SearchScreenUi(navController = navController)
}

@OptIn(FlowPreview::class)
@Composable
fun SearchScreenUi(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = "")) }
    var searchList by remember { mutableStateOf<List<SearchProductsModel>?>(null) }
    val searchResult by viewModel.searching.collectAsState()
    when (searchResult) {
        is NetworkResult.Success -> {
            searchList = searchResult.data ?: emptyList()
        }
        is NetworkResult.Error -> {
            Log.i("5555", "SearchScreenUi: ${searchResult.message}")
        }
        is NetworkResult.Loading -> {}

    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))
            Icon(
                painter = painterResource(id = R.drawable.arrow_back2),
                contentDescription = "arrow back",
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.SearchScreen.route) {
                            inclusive = true
                        }
                    }

                },
                tint = Color.DarkGray
            )
            TextField(
                value = textFieldValueState,
                onValueChange = {
                    textFieldValueState = it
                    CoroutineScope(Dispatchers.IO).launch {
                        flowOf(textFieldValueState)
                            .debounce(300)
                            .distinctUntilChanged()
                            .collectLatest { viewModel.searchProduct(textFieldValueState.text) }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        start = MaterialTheme.spacing.small,
                        end = MaterialTheme.spacing.small
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
                    unfocusedIndicatorColor = MaterialTheme.colors.searchBarBg,
                    cursorColor = MaterialTheme.colors.CursorColor
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.search_all_products),
                        fontFamily = font_standard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color.Gray
                    )

                },
                textStyle = TextStyle(
                    textDirection = TextDirection.ContentOrRtl
                )
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        }

        if (searchList?.isNotEmpty() == true) {
            if (!textFieldValueState.text.isNullOrBlank()) {

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 4.dp)
                ) {
                    searchList?.forEachIndexed { _, searchProductsModel ->
                        item {
                            ItemFound(
                                item = searchProductsModel,
                                navController = navController
                            )
                        }
                    }
                }

                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.small)
                        .clickable {
                            navController.navigate(Screen.ProductListScreen.withArgs(searchList!![0].name)) {
                                popUpTo(Screen.SearchScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.search_all_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(45.dp)
                            .weight(0.1f)
                    )
                    Text(
                        text = " ${stringResource(id = R.string.all_products_search_category) + " " + searchList!![0].name}",
                        fontFamily = font_standard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.weight(0.9f)
                    )
                }
            } else {
                searchList = emptyList()
            }
        } else {
            Column {
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                HotProductSearch()
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                OnlineShoppingAdviceCard()
            }

        }

    }
}

