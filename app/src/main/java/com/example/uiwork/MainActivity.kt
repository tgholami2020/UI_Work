package com.example.uiwork

import android.accounts.AuthenticatorDescription
import android.content.pm.ModuleInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.ProgressIndicatorDefaults.IndicatorBackgroundOpacity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uiwork.ui.theme.UIWorkTheme
import java.io.StringReader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            addUI()

        }
    }
}
@Composable
fun addUI(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        MyFloatingActionBar()
        FloatingActionBar(onClick = { /*TODO*/ }) {
        }
        CircularProgressIndicator(color= colorResource(id = R.color.black),
        strokeWidth = 4.dp)
        LinearProgressIndicator(progress = 0.5f)
        myAlertDialog()
    }
}

// add float Acton bar
@Composable
fun MyFloatingActionBar() {
    FloatingActionButton(onClick = { },
    backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black,
        content = {
            Icon(Icons.Filled.Favorite, contentDescription = " Test Tab")
        }
    )
}

@Composable
fun FloatingActionBar(
    onClick:() ->Unit,
    modifier: Modifier= Modifier,
    shape: Shape= MaterialTheme.shapes.small.copy(CornerSize(50)),
    backgroundColor: Color= MaterialTheme.colors.secondary,
    elevation: FloatingActionButtonElevation= FloatingActionButtonDefaults.elevation(),
    content: @Composable () -> Unit
){
}

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier= Modifier,
    tint: Color= LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
 ){
}
//add progress bar
@Composable
fun CircularProgressIndicator(
    modifier: Modifier=Modifier,
    color: Color=MaterialTheme.colors.secondaryVariant,
    strokeWidth: Dp =ProgressIndicatorDefaults.StrokeWidth
){
}
//add Alert dialog
@Composable
fun myAlertDialog(){
    val shouldShowDialog = remember { mutableStateOf(true) } // 1
    if (shouldShowDialog.value) { // 2
        AlertDialog( // 3
            onDismissRequest = { // 4
                shouldShowDialog.value = false
                //JetFundamentalsRouter.navigateTo(Screen.Navigation)
            },
            // 5
            title = { Text(text = "Alert Dialog") },
            text = { Text(text = " JetPack Compose Alert dialog") },
            confirmButton = { // 6
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor =
                    colorResource(id = R.color.black)),
                    onClick = {
                        shouldShowDialog.value = false
                       // JetFundamentalsRouter.navigateTo(Screen.Navigation)
                    }
                ) {
                    Text(
                        text = "confirm",
                        color = Color.White
                    )
                }
            }
        )
    }
}




@Composable
fun LinearProgressIndicator(
    progress: Float,
    modifier: Modifier=Modifier,
    color: Color=MaterialTheme.colors.onSecondary,
    backgroundColor: Color=color.copy(alpha = IndicatorBackgroundOpacity)
){
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UIWorkTheme {
       addUI()
    }
}