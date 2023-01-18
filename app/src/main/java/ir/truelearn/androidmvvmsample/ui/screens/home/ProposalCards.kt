package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ProposalCards(urlProposalList: List<String>){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(292.dp)
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            ProposalCardItem(imgLink = urlProposalList[0])
            ProposalCardItem(imgLink = urlProposalList[1])
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            ProposalCardItem(imgLink = urlProposalList[2])
            ProposalCardItem(imgLink = urlProposalList[3])
        }
    }
}
@Composable
fun ProposalCardItem(imgLink: String) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .size(175.dp, 130.dp)
            .padding(horizontal = 4.dp, vertical = 4.dp),
    ) {
        Image(
            painter = rememberAsyncImagePainter(imgLink),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}