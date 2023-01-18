package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.runtime.Composable

@Composable
fun ProposalCardSection() {
    val urlList = listOf(
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4f58b192407ed83e4271555cf8f4213409229189_1672864993.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4355945a3ff60f3dbe6a6d31fdb86bba0281aaa6_1668268672.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/e2023fd29340b5a4e0569a13651d2a9af34ff87d_1672834922.jpg?x-oss-process=image/quality,q_95",
        "https://dkstatics-public.digikala.com/digikala-adservice-banners/4244d085416507f88a92e433ded27e05690e5f6b_1672865205.jpg?x-oss-process=image/quality,q_95"
    )
    ProposalCards(urlProposalList = urlList)
}