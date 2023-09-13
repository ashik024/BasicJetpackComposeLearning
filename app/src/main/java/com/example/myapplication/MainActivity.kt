package com.example.myapplication

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter= painterResource(id = R.drawable.test)
            val title="Leo Messi"
            val contentDescription="The Goat"

            ImageCard(painter = painter, contentDescription =contentDescription , title =title )
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

@Composable
fun ImageCard(

    painter: Painter,
    contentDescription:String,
    title: String,
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
                    Text(text = title,
                        style = androidx.compose.ui.text.TextStyle(Color.White, fontSize = 16.sp)

                    )
                    Text(text = contentDescription,
                        style = androidx.compose.ui.text.TextStyle(Color.Red, fontSize = 12.sp)

                    )
                }


            }
        }

    }
}
