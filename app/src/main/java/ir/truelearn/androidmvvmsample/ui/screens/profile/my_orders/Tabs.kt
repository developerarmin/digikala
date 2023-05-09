package ir.truelearn.androidmvvmsample.ui.screens.profile.my_orders

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Square
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.data.model.profile.TabItem
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.ui.theme.font_standard
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    val list = listOf<TabItem>(
        TabItem(
            stringResource(id = R.string.waiting_for_purchase),
            Icons.Filled.Square
        )
        { TabContentScreen(content = stringResource(id = R.string.waiting_for_purchase)) },

        TabItem(
            stringResource(id = R.string.processing_orders),
            Icons.Filled.Square
        )
        { TabContentScreen(content = stringResource(id = R.string.processing_orders)) },

        TabItem(
            stringResource(id = R.string.delivered_orders),
            Icons.Filled.Square
        )
        { TabContentScreen(content = stringResource(id = R.string.delivered_orders)) },

        TabItem(
            stringResource(id = R.string.canceled_orders),
            Icons.Filled.Square
        )
        { TabContentScreen(content = stringResource(id = R.string.canceled_orders)) },

        TabItem(
            stringResource(id = R.string.returned_orders),
            Icons.Filled.Square
        )
        { TabContentScreen(content = stringResource(id = R.string.returned_orders)) },


        )

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.darkText,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = MaterialTheme.colors.digikalaRed
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                icon = {
                    Icon(imageVector = list[index].icon, contentDescription = null, tint = Color.White)
                },
                text = {
                    Text(
                        list[index].title,
                        color = if (pagerState.currentPage == index) Color.DarkGray else Color.LightGray,
                        fontFamily = font_standard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.wrapContentWidth()
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }

    }

}