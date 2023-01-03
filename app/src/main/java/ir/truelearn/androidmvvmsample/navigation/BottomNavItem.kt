package ir.truelearn.androidmvvmsample.navigation

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val selectedIcon: Painter,
    val deSelectedIcon: Painter
)