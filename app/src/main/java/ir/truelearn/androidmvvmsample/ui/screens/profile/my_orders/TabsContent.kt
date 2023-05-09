package ir.truelearn.androidmvvmsample.ui.screens.profile.my_orders

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import ir.truelearn.androidmvvmsample.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = 5) { page ->
        when (page) {
            0 -> TabContentScreen(content = stringResource(id = R.string.waiting_for_purchase))
            1 -> TabContentScreen(content = stringResource(id = R.string.processing_orders))
            2 -> TabContentScreen(content = stringResource(id = R.string.delivered_orders))
            3 -> TabContentScreen(content = stringResource(id = R.string.canceled_orders))
            4 -> TabContentScreen(content = stringResource(id = R.string.returned_orders))
        }
    }
}