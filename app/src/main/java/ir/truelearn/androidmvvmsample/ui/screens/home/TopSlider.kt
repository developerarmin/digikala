package ir.truelearn.androidmvvmsample.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.LocalShape
import ir.truelearn.androidmvvmsample.ui.theme.LocalSpacing
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopSlider(viewModel: HomeViewModel = hiltViewModel()) {
    var list by remember { mutableStateOf<List<Slider>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }

    LaunchedEffect(Dispatchers.Main) {
        viewModel.slider.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        list = it
                    }
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.d("5555", "TopSlider error:${result.message} ")
                }
                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            //.background(MaterialTheme.colors.DigikalaLightRed)
            .background(Color.White)
    ) {
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
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = LocalSpacing.current.extraSmall, vertical = LocalSpacing.current.small)
            ) {
                val pagerState = rememberPagerState()
                var imageUrl by remember { mutableStateOf("") }

                viewModel.slider.value.data?.size?.let {
                    HorizontalPager(
                        count = it,
                        state = pagerState,
                        contentPadding = PaddingValues(horizontal = LocalSpacing.current.medium),
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                    ) { page ->
                        imageUrl = viewModel.slider.value.data?.get(page)?.image.toString()
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            val painter = rememberAsyncImagePainter(
                                ImageRequest.Builder(LocalContext.current)
                                    .data(data = imageUrl)
                                    .apply(block = fun ImageRequest.Builder.() { scale(Scale.FILL) })
                                    .build()
                            )
                            Image(
                                painter = painter, contentDescription = "", Modifier
                                    .padding(8.dp)
                                    .clip(LocalShape.current.medium)
                                    .fillMaxSize(), contentScale = ContentScale.FillBounds
                            )

                            HorizontalPagerIndicator(
                                pagerState = pagerState,
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .padding(LocalSpacing.current.semiLargeTwo),
                                activeColor = Color.Black,
                                inactiveColor = Color.LightGray,
                                indicatorWidth = LocalSpacing.current.small,
                                indicatorHeight = LocalSpacing.current.small,
                                indicatorShape = CircleShape
                            )
                        }
                    }
                }

                LaunchedEffect(key1 = pagerState.currentPage) {
                    viewModel.slider.value.data?.size?.let {
                        delay(3000)
                        var newPosition = pagerState.currentPage + 1
                        if (newPosition > it - 1) newPosition = 0
                        //pagerState.animateScrollToPage(newPosition)
                        pagerState.scrollToPage(newPosition)
                    }
                }
            }
        }
    }
}

