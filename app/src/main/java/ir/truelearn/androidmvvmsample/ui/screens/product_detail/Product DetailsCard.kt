package ir.truelearn.androidmvvmsample.ui.screens.product_detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.truelearn.androidmvvmsample.ui.theme.spacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductDetailCard(){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp)) {
        Card(onClick = { /*TODO*/ }, modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(Color.White)
            , shape = RoundedCornerShape(0.dp)
        ) {
           Column(modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = MaterialTheme.spacing.medium)) {
               Text(text = "ویژگی های محصول"
                   , color = Color.Black
                   ,style = MaterialTheme.typography.h4,
                   fontWeight = FontWeight.Bold,
               )
               Spacer(modifier = Modifier.height(15.dp))
               Row() {
                   Text(text = "ترکیبات :"
                       , color = Color.Gray
                       ,style = MaterialTheme.typography.h5,
                       fontWeight = FontWeight.Bold,
                   )
                   Text(text = "فلوراید"
                       , color = Color.DarkGray
                       ,style = MaterialTheme.typography.h5,
                       fontWeight = FontWeight.Bold,
                   )

               }

           }
        }

        Card(onClick = { /*TODO*/ }, modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(Color.White)
            , shape = RoundedCornerShape(0.dp)
        ) {
            Column(modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium)) {
                Row() {
                    Text(text = "مشخصات فنی"
                        , modifier = Modifier.weight(1f)
                        , color = Color.Black
                        ,style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.ArrowBack , contentDescription = null, tint = Color.Gray, modifier = Modifier.size(20.dp))
                    }
                }
                //Spacer(modifier = Modifier.weight(1f))
                Row(

                    ) {
                    Text(text = "بازخورد درباره مشخصات این کالا",
                        modifier=Modifier.weight(1f),
                         textAlign = TextAlign.End
                        , color = Color.Gray
                        ,style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Icon(Icons.Outlined.Info , contentDescription =null, tint = Color.Gray, modifier = Modifier.size(20.dp)  )
                }

            }
        }





    }
}