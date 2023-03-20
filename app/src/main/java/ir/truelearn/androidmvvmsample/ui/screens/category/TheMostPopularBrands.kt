package ir.truelearn.androidmvvmsample.ui.screens.category



import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.CircularCategoryItem
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.viewmodel.CategoryViewModel
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TheMostPopularBrands() {

    val viewModel: CategoryViewModel = hiltViewModel()
    var list by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true) {
        viewModel.getAllDataFromServer()
    }
    LaunchedEffect(Dispatchers.Main) {

        viewModel.categories_im.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        list = it
                        Log.d("3636", "Success: ${result.message} ")
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("3636", "InitAmazingItems error:${result.message} ")
                    // show error message
                }
                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }

    var selectedIndex by remember {
        mutableStateOf(-1)
    }
//    val strList = listOf("کالای دیجیتال", "موبایل", "ابزار، لوازم ساختمانی و صنعتی")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 60.dp),
    ) {
        Text(text = "محبوب ترین برندها"
        )

        if (loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Loading3Dots(isDark = false)
            }
        } else {

            Log.e("3636","list is ${list.size}")
                LazyRow() {
                    items(list.size) { index ->
                    OutlinedButton(
                        onClick = {

                        }, shape = RoundedCornerShape(32.dp),
                        border = if (selectedIndex == index) BorderStroke(1.dp, Color.Red)
                        else BorderStroke(1.dp, Color(0xFFEDEDED))
                    ) {
                        Text(text = list[index].name,
                            modifier = Modifier
                                .selectable(
                                    selected = selectedIndex == index,
                                    onClick = {
                                        selectedIndex = index
                                    }
                                )
                            , color = if (selectedIndex == index) Color.Red
                            else Color.Black)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}