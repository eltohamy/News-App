package com.news.domain.presentation.basecomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.news.R

@Composable
fun RetryButton(modifier: Modifier, onItemClick: (String) -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth().width(20.dp)
            .padding(horizontal = 10.dp),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
        // below line is use to add shape for our button.
        shape = MaterialTheme.shapes.medium,
        onClick = {
            onItemClick("")
        }
    ) {
        Text(
            text = stringResource(id = R.string.retry),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
