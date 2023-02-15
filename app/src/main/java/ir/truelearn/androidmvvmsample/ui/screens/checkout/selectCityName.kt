package ir.truelearn.androidmvvmsample.ui.screens.checkout


import android.annotation.SuppressLint
import android.util.Log
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


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun selectCityName(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel(),
    flag: String = "1"
) {

    val provinceList = arrayListOf(
        "اردبیل",
        "تبریز",
        "تهران",
        "شیراز",
        "رشت",
        "همدان",
        "قم",
        "گرگان",
        "مشهد",
        "کرمان",

        )
    val citiesList = arrayListOf(
        "اردبیل",
        "نیر",
        "سرعین",
        "پارس آباد",
        "بیله سوار",
        "مشکین شهر",
        "نمین",
        )
    var selectList: List<String> = if (flag.equals("1")) provinceList
    else
        citiesList

    var tabBarTitle: String = if (flag.equals("1")) "استان مورد نظر را انتخاب کنید"
    else
        "شهر مورد نظر را انتخاب کنید"

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            topBar = { TopBar(navController,tabBarTitle) },
        ) {
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
                        citiesList = selectList,
                        flag = flag
                    )
                }
            }
        }
}

@Composable
fun TopBar(navController: NavController,title:String) {
    TopAppBar(
        elevation = 4.dp,
        title = { Text(text = title, fontSize = 16.sp) },
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
    citiesList: List<String>,
    flag: String
) {

    var filteredCities: List<String>
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
                    if (flag.equals("1"))
                        viewModel.dlgProvinceName.value = selectedCity
                    else
                        viewModel.dlgCityName.value = selectedCity

                    navController.popBackStack()
                }
            )
        }
    }
}




