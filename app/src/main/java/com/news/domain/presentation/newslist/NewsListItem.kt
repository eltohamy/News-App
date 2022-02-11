package com.news.domain.presentation.newslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.news.domain.models.newslist.Result

@Composable
fun NewsListItem(result: Result, onItemClick: (Result) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onItemClick(result) }
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        if (result.media?.isNotEmpty() == true && result.media[0]?.mediaMetaData?.isNotEmpty() == true)
        Card(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp).clip(CircleShape).align(alignment = Alignment.CenterVertically),
            elevation = 3.dp
        ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
//                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                        .clip(CircleShape)
//                    .border(width = 1.dp, shape = CircleShape, color = Color.Blue)
                    ,
                    contentScale = ContentScale.Fit,
                    painter = rememberImagePainter(
                        result.media[0]?.mediaMetaData?.get(0)?.url ?: ""
                    ),
                    contentDescription = null
                )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.93f).padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.Start
        ) {
            result.title?.let { title ->
                Text(
                    text = title,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(vertical = 3.dp).fillMaxWidth()
                )
            }
            Box(modifier = Modifier.fillMaxWidth().wrapContentWidth().padding(top = 3.dp)) {
                result.byline?.let { byline ->
                    Text(
                        text = if (byline.length > 50) byline.take(50) + "\n" else byline + "\n",
                        color = Color.Gray,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Start,
                        fontStyle = FontStyle.Normal,
                        lineHeight = 18.sp,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 3.dp).fillMaxWidth()
                            .align(Alignment.TopStart)
                    )
                }
                Spacer(modifier = Modifier.padding(start = 7.dp))
                result.published_date?.let { published_date ->
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .padding(top = 8.dp, start = 10.dp)
                            .align(alignment = Alignment.BottomEnd)
                    ) {
                        Icon(Icons.Outlined.DateRange, contentDescription = null, tint = Color.Gray)
                        Text(
                            text = published_date,
                            color = Color.Gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.Serif,
                            textAlign = TextAlign.Start,
                            fontStyle = FontStyle.Normal,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                                .align(alignment = Alignment.CenterVertically).wrapContentWidth()
                        )
                    }
                }
            }
        }
        Icon(
            Icons.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NewsListItemTest() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { /*onItemClick(result)*/ }
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Card(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp).clip(CircleShape).align(alignment = Alignment.CenterVertically),
            elevation = 3.dp
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
//                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .clip(CircleShape)
//                    .border(width = 1.dp, shape = CircleShape, color = Color.Blue)
                ,
                contentScale = ContentScale.Fit,
                painter = rememberImagePainter(""),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.93f).padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "123456789",
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Start,
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                modifier = Modifier.padding(vertical = 3.dp).fillMaxWidth()
            )
            Box(modifier = Modifier.fillMaxWidth().wrapContentWidth().padding(top = 3.dp)) {
                Text(
                    text = "01234567890123456789012345678901234567890123456789",
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    lineHeight = 18.sp,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 3.dp).fillMaxWidth()
                        .align(Alignment.TopStart)
                )
                Spacer(modifier = Modifier.padding(start = 7.dp))
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(top = 8.dp, start = 10.dp)
                        .align(alignment = Alignment.BottomEnd)
                ) {
                    Icon(Icons.Outlined.DateRange, contentDescription = null, tint = Color.Gray)
                    Text(
                        text = "Date",
                        color = Color.Gray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Start,
                        fontStyle = FontStyle.Normal,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 8.dp)
                            .align(alignment = Alignment.CenterVertically).wrapContentWidth()
                    )
                }
            }
        }
        Icon(
            Icons.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

