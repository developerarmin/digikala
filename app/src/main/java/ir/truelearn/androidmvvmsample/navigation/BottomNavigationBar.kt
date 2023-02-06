package ir.truelearn.androidmvvmsample.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.*
import ir.truelearn.androidmvvmsample.util.DigitHelper
import ir.truelearn.androidmvvmsample.viewmodel.CartViewModel
import ir.truelearn.androidmvvmsample.viewmodel.HomeViewModel


@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit,
    viewModel: CartViewModel = hiltViewModel()
) {
    val items = listOf(
        BottomNavItem(
            name = stringResource(R.string.home),
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.home_fill),
            deSelectedIcon = painterResource(id = R.drawable.home_outline)
        ),
        BottomNavItem(
            name = stringResource(R.string.category),
            route = Screen.Category.route,
            selectedIcon = painterResource(id = R.drawable.category_fill),
            deSelectedIcon = painterResource(id = R.drawable.category_outline)
        ),
        BottomNavItem(
            name = stringResource(R.string.basket),
            route = Screen.Basket.route,
            selectedIcon = painterResource(id = R.drawable.cart_fill),
            deSelectedIcon = painterResource(id = R.drawable.cart_outline)
        ),
        BottomNavItem(
            name = stringResource(id = R.string.my_digikala),
            route = Screen.Profile.route,
            selectedIcon = painterResource(id = R.drawable.user_fill),
            deSelectedIcon = painterResource(id = R.drawable.user_outline)
        ),

        )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }

    if (showBottomBar) {
        BottomNavigation(
            modifier = modifier,
            backgroundColor = Color.White,
            elevation = 5.dp
        ) {
//            items.forEach { item ->
            val cartCounter = viewModel.cartItemCounter.value
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colors.unSelectedBottomBar,
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            if (selected) {
                                if(index==2 && cartCounter>0 )
                                    IconWithBadge(cartCounter,item.selectedIcon)
                                else
                                    Icon(
                                        modifier = Modifier
                                            .height(24.dp),
                                        painter = item.selectedIcon,
                                        contentDescription = item.name
                                    )
                            } else {
                                if(index==2 && cartCounter>0 )
                                    IconWithBadge(cartCounter,item.deSelectedIcon)
                                else
                                Icon(
                                    modifier = Modifier
                                        .height(24.dp),
                                    painter = item.deSelectedIcon,
                                    contentDescription = item.name
                                )
                            }
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }
                    }
                )
            }
        }
    }

}

