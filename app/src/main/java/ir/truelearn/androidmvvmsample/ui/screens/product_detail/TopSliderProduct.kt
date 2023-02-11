package ir.truelearn.androidmvvmsample.ui.screens.product_detail

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
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.model.product_detail.ImageSlider
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.ui.component.Loading3Dots
import ir.truelearn.androidmvvmsample.ui.theme.LocalShape
import ir.truelearn.androidmvvmsample.ui.theme.LocalSpacing
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel
import ir.truelearn.androidmvvmsample.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopSliderProduct( list:List<ImageSlider>,viewModel: ProductDetailViewModel = hiltViewModel()) {
    var loading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
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
            ) {
                val pagerState = rememberPagerState()
                var imageUrl by remember { mutableStateOf("") }

               list.size.let {
                    HorizontalPager(
                        count = it,
                        state = pagerState,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                    ) { page ->
                        imageUrl = list[page].image
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
                    list.size?.let {
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