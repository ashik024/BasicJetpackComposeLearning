package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import java.util.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            Scaffold(modifier = Modifier.fillMaxSize()) {
//
//            }

Column(modifier = Modifier.fillMaxSize().padding(bottom = 20.dp)) {

    val painter = painterResource(id = R.drawable.test)
    val title = "Leo "
    val title2 = "Messi"
    val contentDescription = "The "
    val contentDescription2 = "Goat"

            ImageCard(painter = painter, contentDescription =contentDescription,contentDescription2=contentDescription2 , title =title ,title2=title2)

            TextField()
            loadLazyColumn()
}
//            Column (
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
//            ){
//                Text(text = "Henry")
//                Text(text = "Rvp")
//                Text(text = "Saka")
//            }
//
//            Row (
//                modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//
//                horizontalArrangement = Arrangement.SpaceAround,
//                verticalAlignment = Alignment.CenterVertically
//            )
//            {
//                Text(text = "Bergcamp")
//                Text(text = "Ozil")
//                Text(text = "Odegard")
//            }



            }

            }




}


@OptIn(ExperimentalTextApi::class)
@Composable
fun ImageCard(

    painter: Painter,
    contentDescription:String,
    contentDescription2:String,
    title: String,
    title2: String,
    modifier: Modifier= Modifier
){

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(15.dp),
        elevation =CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painter,
                contentDescription =contentDescription,
                contentScale = ContentScale.Crop
            )
            Box (modifier= Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart){

                Column (modifier= Modifier.fillMaxWidth()){
                    val colorList: List<Color> = listOf(Color.Red, Color.Blue,
                        Color.Magenta, Color.Yellow, Color.Green, Color.Red)
                    Text(
                      text =   buildAnnotatedString {

                            withStyle(style = SpanStyle( Color.White, fontSize = 16.sp)) {
                                append(title)

                            }

                            withStyle(style = SpanStyle(Color.Green, fontSize = 32.sp,fontWeight = FontWeight.Bold)) {
                                append(title2)
                            }

                        }

                    )
                    Text(


                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(Color.White, fontSize = 16.sp)){
                                append(contentDescription)
                            }
                            withStyle(style = SpanStyle(fontSize = 32.sp,fontWeight = FontWeight.Bold, brush = Brush.linearGradient(colorList))){
                                append(contentDescription2)
                            }
                        }
                    )
                }


            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(){
    val snackbarHostState = remember { SnackbarHostState() }
    var textFeildState by remember {
        mutableStateOf("")
    }
    val scope= rememberCoroutineScope()


    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(20.dp),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        })
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = textFeildState,
                label = {
                    Text(text = "Enter Your Name")
                },
                onValueChange ={
                    textFeildState=it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
                )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("My name is $textFeildState")
                }
            }) {
                
                Text(text = "Submit")
            }
        }
    }
    
}

@Composable
fun loadLazyColumn(){
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        content = {
//            items(50){
//                Text(text = "Item Number $it",
//                    fontSize = 24.sp,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxSize().padding(8.dp)
//                    )
//            }

            itemsIndexed(
                listOf("Henry","Bergcamp","Wright","Viera","Adams","Pires","Lumberg","Silva","Kolo","Campbel","Cole","Luaren","Lehman","Wenger")
            ){
                index, data ->

                Text(text = "$data",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize().padding(8.dp)
                )
            }

    })
}


