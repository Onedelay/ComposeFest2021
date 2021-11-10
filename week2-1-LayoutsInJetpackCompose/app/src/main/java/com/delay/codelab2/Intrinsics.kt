package com.delay.codelab2

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delay.codelab2.ui.theme.Codelab2Theme


@Composable
fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)

                // 측정된 최소 너비 제약조건에 관계 없이 원하는 너비로 측정할 수 있도록 허용
                // unbounded = true 일 경우 최대 너비도 고려하지 않음
                // 컨텐츠 측정 크기가 최소 너비 제약보다 작은 경우, 최소 너비 내에서 정렬
                // 컨텐츠 측정 크기가 최대 너비 제약보다 큰 경우(unbounded = true 일 경우에만) 최대 너비에 맞춰 정렬
                .wrapContentWidth(Alignment.Start),
            text = text1
        )

        Divider(color = Color.Black, modifier = Modifier
            .fillMaxHeight()
            .width(1.dp))
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End),
            text = text2
        )
    }
}

@Preview()
@Composable
fun TwoTextsPreview() {
    Codelab2Theme {
        Surface {
            TwoTexts(text1 = "Hi", text2 = "there")
        }
    }
}