package com.news.domain.presentation.newsdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.news.domain.presentation.basecomponents.BaseAppBar

@Composable
fun NewsDetailsScreen(
    navController: NavController,
    title: String?,
    abstractString: String?,
    url: String?,
    publishedDate: String?
) {
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState // attaching `scaffoldState` to the `Scaffold`
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            BaseAppBar(title = title ?: "", navController)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp), elevation = 2.dp
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(3.dp))
                        .border(width = 10.dp, shape = CircleShape, color = Color.Transparent),
                    contentScale = ContentScale.FillWidth,
                    painter = rememberImagePainter(url),
                    contentDescription = null
                )
            }
            Spacer(Modifier.padding(vertical = 5.dp))
            Text(
                text = publishedDate ?: "",
                color = Color.Gray,
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.padding(vertical = 5.dp))
            Text(
                text = title ?: "",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.padding(vertical = 5.dp))
            Text(
                text = abstractString ?: "",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.padding(vertical = 5.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NewsDetailsScreenTest(
) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        BaseAppBar(title = "title", navController = rememberNavController())
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp), elevation = 2.dp
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(3.dp))
                    .border(width = 10.dp, shape = CircleShape, color = Color.Transparent),
                contentScale = ContentScale.Fit,
                painter = rememberImagePainter(""),
                contentDescription = null
            )
        }
        Spacer(Modifier.padding(vertical = 5.dp))
        Text(
            text = "publishedDate",
            color = Color.Gray,
            fontSize = 14.sp,
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.padding(vertical = 5.dp))
        Text(
            text = "title",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.padding(vertical = 5.dp))
        Text(
            text = "abstractString",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.padding(vertical = 5.dp))
    }
}