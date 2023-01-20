package ir.truelearn.androidmvvmsample.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.component.CircularCategoryItem
import ir.truelearn.androidmvvmsample.ui.theme.DigikalaLightRed
import ir.truelearn.androidmvvmsample.ui.theme.darkText
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun CategoryListSection() {

    val categoryTitle = "خرید بر اساس دسته بندی"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .padding(MaterialTheme.spacing.small),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = categoryTitle,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
        )
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            columns = GridCells.Fixed(3),
//            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large),
//            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
//            contentPadding = PaddingValues(MaterialTheme.spacing.medium),
            content = {
                items(11) {
                    CircularCategoryItem(
                        categoryImage = painterResource(id = R.drawable.juice),
                        categoryName = "کالای دیجیتال", MaterialTheme.colors.DigikalaLightRed
                    )
                }

            }
        )

    }

}