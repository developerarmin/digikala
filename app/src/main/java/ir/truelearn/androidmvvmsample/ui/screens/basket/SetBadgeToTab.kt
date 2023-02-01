package ir.truelearn.androidmvvmsample.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.ui.theme.digikalaRed
import ir.truelearn.androidmvvmsample.util.DigitHelper

@Composable
fun SetBadgeToTab(selectedTabIndex:Int,index:Int,badge: Int) {
    Card(
        modifier = Modifier
            .background(Color.Transparent)
    ) {
                if (selectedTabIndex == index) {
                        Text(
                            text ="${DigitHelper.digitBySeparator(DigitHelper.digitByLocate(badge.toString()))} ",
                            modifier = Modifier
                                .background(color = MaterialTheme.colors.digikalaRed)
                                .padding(top=0.dp, bottom = 0.dp, start = 5.dp, end = 1.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                        )
                } else {
                        Text(
                            text ="${DigitHelper.digitBySeparator(DigitHelper.digitByLocate(badge.toString()))} ",
                            modifier = Modifier
                                .background(color = Color.Gray)
                                .padding(top=0.dp, bottom = 0.dp, start = 5.dp, end = 1.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                        )
            }

    }
}