package ir.truelearn.androidmvvmsample.ui.screens.checkout


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import java.util.*


@Composable
fun selectCityName(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel(),
    flag: Int = 1
) {
    val citiesList = arrayListOf(
        "اردبیل",
        "تبریز",
        "تهران",
        "شیراز",
        "رشت",
        "همدان",
        "اردبیل",
        "تبریز",
        "تهران",
        "همدان",

        )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Scaffold(
            topBar = { TopBar(navController) },
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxSize()
            ) {

                val textState = remember { mutableStateOf(TextFieldValue("")) }
                Column {
                    SearchView(textState)
                    CityList(
                        navController = navController,
                        viewModel = viewModel,
                        state = textState,
                        citiesList = citiesList,
                        flag = flag
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    TopAppBar(
        elevation = 4.dp,
        title = { Text(text = "استان مورد نظر را انتخاب کنید", fontSize = 16.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        actions = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.Close, null)
            }
        }
    )

}


@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .fillMaxWidth(),

        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        placeholder = { Text(text = "جستجو", color = Color.Gray) },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun CityListItem(cityText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(cityText) })
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(text = cityText, color = Color.Gray)
    }
}


@Composable
fun CityList(
    navController: NavController,
    viewModel: CartViewModel,
    state: MutableState<TextFieldValue>,
    citiesList: ArrayList<String>,
    flag: Int
) {

    var filteredCities: ArrayList<String>
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(MaterialTheme.spacing.small)
            .fillMaxWidth()

    ) {

        val searchedText = state.value.text
        filteredCities = if (searchedText.isEmpty()) {
            citiesList
        } else {
            val resultList = ArrayList<String>()
            for (city in citiesList) {
                if (city.lowercase(Locale.getDefault())
                        .contains(searchedText.lowercase(Locale.getDefault()))
                ) {
                    resultList.add(city)
                }
            }
            resultList
        }

        items(filteredCities) { filteredCity ->
            CityListItem(
                cityText = filteredCity,
                onItemClick = { selectedCity ->
                    if (flag == 1) {
                        viewModel.dlgProvinceName.value = selectedCity
                    } else {
                        viewModel.dlgCityName.value = selectedCity
                        viewModel.dlgCityState.value = false
                    }
                    navController.popBackStack()
                }
            )
        }

    }

}




