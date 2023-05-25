package ir.truelearn.androidmvvmsample.ui.screens.profile.userAccountInformation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.truelearn.androidmvvmsample.R
import ir.truelearn.androidmvvmsample.ui.theme.searchBarBg
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@Composable
fun UserAccountItem(
    title : String ,
    information : String = "-",
    route : String = "" ,
    navController: NavController
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = MaterialTheme.spacing.mediumTwo,
            vertical = MaterialTheme.spacing.small
        )
        
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h4,
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

                Text(
                    text = information,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold
                )
            }
            IconButton(onClick = { navController.navigate(route) }
                , modifier = Modifier.size(13.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
        
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
        
        //Divider(modifier = Modifier.fillMaxWidth())
    }

}



@Composable
fun AddLegalInformationItem(
    title : String ,
    information : String = "-",
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = MaterialTheme.spacing.mediumTwo,
            vertical = MaterialTheme.spacing.small
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

                Text(
                    text = information,
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Light,
                    maxLines = 3,
                    color = Color.Gray
                )
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(13.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
    }
}