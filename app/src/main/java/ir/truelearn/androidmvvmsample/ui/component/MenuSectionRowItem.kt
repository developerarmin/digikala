package ir.truelearn.androidmvvmsample.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun MenuSectionRowItem(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    isHaveDivider: Boolean,
    modifier: Modifier = Modifier,
    action: @Composable () -> Unit = { Spacer(Modifier.height(0.dp)) },
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = MaterialTheme.spacing.medium)
    ) {
        Column(
            Modifier

                .fillMaxHeight()
                .weight(0.1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            icon()
        }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(0.9f)
                .padding(horizontal = MaterialTheme.spacing.small),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                text()
                action()
            }
            if (isHaveDivider) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .alpha(0.4f),
                    color = Color.LightGray,
                )
            }
        }

    }
}