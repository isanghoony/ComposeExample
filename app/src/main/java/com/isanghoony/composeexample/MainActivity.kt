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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.isanghoony.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 앱의 기본 테마를 설정하고 화면 전체를 채우는 Surface를 만듭니다.
            ComposeExampleTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val state by remember { mutableStateOf("main") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        NavHost(
            navController = navController,
            startDestination = state
        ) {
            composable("main") {
                MainScreen(navController)
                Log.e("Screen_Test","MainScreen show")
            }
            composable("constraintLayout") {
                ConstraintLayoutScreen()
                Log.e("Screen_Test","ConstraintLayoutScreen show")
            }
            composable("dialog") {
                DialogScreen()
                Log.e("Screen_Test","DialogScreen show")
            }
            composable("customDialog") {
                CustomDialogScreen()
                Log.e("Screen_Test","CustomDialogScreen show")
            }
            composable("dropDownMenu") {
                DropDownMenuScreen()
                Log.e("Screen_Test","DropDownMenuScreen show")
            }
            composable("snackBar") {
                SnackBarScreen()
                Log.e("Screen_Test","SnackBarScreen show")
            }
            composable("bottomAppBar") {
                BottomAppBarScreen()
                Log.e("Screen_Test","BottomAppBarScreen show")
            }
        }
    }
}


@Composable
fun MainScreen(navController: NavController) {
    ExampleLazyColumn(
        names = arrayOf(
            "ConstraintLayout",
            "Dialog",
            "CustomDialog",
            "DropDownMenu",
            "SnackBar",
            "BottomAppBar"
        ),
        navController = navController
    )
}

@Composable
fun ExampleLazyColumn(
    names: Array<String>,
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
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
                    when(names[index]) {
                        "ConstraintLayout" -> {
                            navController.navigate("constraintLayout")
                        }

                        "Dialog" -> {
                            navController.navigate("dialog")
                        }

                        "CustomDialog" -> {
                            navController.navigate("customDialog")
                        }

                        "DropDownMenu" -> {
                            navController.navigate("dropDownMenu")
                        }

                        "SnackBar" -> {
                            navController.navigate("snackBar")
                        }

                        /*"bottomAppBar" -> {
                            navController.navigate("bottomAppBar")
                        }*/

                        else -> {
                            Log.e("Screen_Test","${names[index]}")
                        }
                    }
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

@Composable
fun ConstraintLayoutScreen() {
    Text(text = "ConstraintLayoutScreen")
}

@Composable
fun DialogScreen() {
    Text(text = "DialogScreen")
}

@Composable
fun CustomDialogScreen() {
    Text(text = "CustomDialogScreen")
}

@Composable
fun DropDownMenuScreen() {
    Text(text = "DropDownMenuScreen")
}

@Composable
fun SnackBarScreen() {
    Text(text = "SnackBarScreen")
}

@Composable
fun BottomAppBarScreen() {
    Text(text = "BottomAppBarScreen")
}

@Preview(showBackground = true)
@Composable
fun ExamplePreview() {
    ComposeExampleTheme {
        MainScreen(rememberNavController())
    }
}