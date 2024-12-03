package com.example.myapplication

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController, productId: Int) {

    val viewModel = ListScreenViewModel(LocalContext.current)
    val product: Product = viewModel.getProductById(productId)


    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Đặt Món",

                        fontWeight = FontWeight.Bold

                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.White

                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            var localConfig = LocalConfiguration.current
            Box( //hình ảnh chiếm 30% độ cao màn hình bên trong Scaffold
                modifier = Modifier
                    .height((localConfig.screenHeightDp * 3 / 10).dp)
                    .fillMaxSize().background(color = Color.White)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()

                        .align(Alignment.Center),

                    model = product.picture,


                            contentDescription = ""
                )
            }
            Box(
//phần chi tiết khối màu xanh chiếm 70% (cách lề trên 30%)
                modifier = Modifier
                    .padding(
                        top = (localConfig.screenHeightDp * 3 / 10).dp
                    )

                    .fillMaxSize()
                    .clip(

                        shape = RoundedCornerShape(
                            topStartPercent = 8,
                            topEndPercent = 8

                        )
                    )

                    .background(color = Color.Blue),

                ) {
                Column(//chỉ hiển thị nội dung trong 80% của khối xanh
                    modifier = Modifier
                        .height(
                            (LocalConfiguration.current.screenHeightDp * 8 / 10).dp
                        )

                        .verticalScroll(ScrollState(0))

                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = product.name,
                        fontSize = 25.sp,

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                    Text(

                        text = "${product.price} VNĐ",

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = Color.Red
                    )
                    Text(

                        text = product.description,

                        softWrap = true,

                        textAlign = TextAlign.Justify,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Yellow
                    )
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun ProductDetailScreenpv(){
//    MaterialTheme{
//        ProductDetailScreen()
//    }
//}