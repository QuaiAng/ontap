package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ProductCard(product: Product, onClick: () -> Unit){
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 5.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ){
            AsyncImage(
                modifier = Modifier.size(50.dp),
                model = product.picture,
                contentDescription = null
            )
            Spacer(Modifier.width(10.dp))
            Column {
                Text(product.name,
                   fontSize = 20.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
                Spacer(Modifier.height(5.dp))
                Text(product.price.toString(), fontSize = 15.sp, color = Color.Gray)
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun ProductCardpv(){
//    MaterialTheme{
//        ProductCard()
//    }
//}

