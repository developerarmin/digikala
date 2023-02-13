package ir.truelearn.androidmvvmsample.ui.screens.checkout

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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ir.truelearn.androidmvvmsample.ui.theme.spacing
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import java.util.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun selectCityNameByDialog(viewModel: CartViewModel,flag:Int, onDismiss: () -> Unit) {
    Dialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        onDismissRequest = onDismiss,
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Scaffold(
                topBar = { TopBar1() },
            ) { padding ->
                Box(
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxSize()
                ) {

                    val textState = remember { mutableStateOf(TextFieldValue("")) }
                    Column {
                        SearchView1(textState)
                        CountryList1(viewModel, state = textState,flag)
                    }
                }
            }
        }
    }
}


@Composable
fun TopBar1() {
    TopAppBar(
        elevation = 4.dp,
        title = { Text(text = "استان مورد نظر را انتخاب کنید", fontSize = 16.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
                actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Close, null)
            }
        }
    )

}


@Composable
fun SearchView1(state: MutableState<TextFieldValue>) {
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
        shape = RoundedCornerShape(8.dp),// RectangleShape, // The TextFiled has rounded corners top left and right by default

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
fun CountryListItem1(countryText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(countryText) })

            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(text = countryText, color = Color.Gray)
    }
}


@Composable
fun CountryList1(viewModel: CartViewModel, state: MutableState<TextFieldValue>,flag:Int) {
    val countries = arrayListOf(
        "اردبیل",
        "تبریز",
        "تهران",
        "شیراز",
        "رشت",
        "همدان",
        "اردبیل",
        "تبریز",
        "تهران",
    )
    var filteredCountries: ArrayList<String>
    val listState = rememberLazyListState()


    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(MaterialTheme.spacing.small)
            .fillMaxWidth()

    ) {
        val searchedText = state.value.text
        filteredCountries = if (searchedText.isEmpty()) {
            countries
        } else {
            val resultList = ArrayList<String>()
            for (country in countries) {
                if (country.lowercase(Locale.getDefault())
                        .contains(searchedText.lowercase(Locale.getDefault()))
                ) {
                    resultList.add(country)
                }
            }
            resultList
        }
        items(filteredCountries) { filteredCountry ->
            CountryListItem1(
                countryText = filteredCountry,
                onItemClick = { selectedCountry ->
                    if(flag==1) {
                        viewModel.dlgProvinceName.value = selectedCountry
                    }else{
                        viewModel.dlgCityName.value = selectedCountry
                        viewModel.dlgCityState.value = false
                    }
                }
            )
        }

    }

}




