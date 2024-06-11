package com.isanghoony.composeexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isanghoony.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 앱의 기본 테마를 설정하고 화면 전체를 채우는 Surface를 만듭니다.
            ComposeExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), // Surface를 화면 전체 크기로 설정합니다.
                    color = Color.White // Surface의 배경색을 Cyan으로 설정합니다.
                ) {
                    ExampleLazyColumn(
                        arrayOf(
                            "ConstraintLayout",
                            "Dialog",
                            "Custom Dialog",
                            "DropDownMenu",
                            "SnackBar",
                            "BottomAppBar"
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ExampleLazyColumn(names: Array<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(), // 컬럼을 화면 전체 크기로 설정합니다.
        verticalArrangement = Arrangement.Center, // 버튼들을 세로 중앙에 정렬합니다.
        horizontalAlignment = Alignment.CenterHorizontally // 버튼들을 가로 중앙에 정렬합니다.
    ) {
        items(names.size) { index ->
            Button(
                /*enabled = false,*/
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    /*contentColor = Color.White,*/
                    disabledContainerColor = Color.DarkGray,
                    disabledContentColor = Color.Gray,
                ),
                onClick = {
                    Log.d("buttonClickedEvent","${index}번째 버튼 클릭!")
                }
            ) {
                Text(
                    text = names[index],
                    color = Color.White,
                    fontStyle = FontStyle.Italic
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExamplePreview() {
    ComposeExampleTheme {
        ExampleLazyColumn(
            arrayOf(
                "ConstraintLayout",
                "Dialog",
                "Custom Dialog",
                "DropDownMenu",
                "SnackBar",
                "BottomAppBar"
            )
        )
    }
}