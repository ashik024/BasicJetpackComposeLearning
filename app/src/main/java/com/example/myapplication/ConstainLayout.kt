package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
class ConstainLayout : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            StyledTextField()


        }
    }

    @Composable
    fun StyledTextField() {
        var nameTFState by remember {
            mutableStateOf("")
        }
        var ageTFState by remember {
            mutableStateOf("")
        }
        var countryTFState by remember {
            mutableStateOf("")
        }

        val constraintSet = ConstraintSet {

            val editTextName = createRefFor("nameTxt")
            val editTextAge = createRefFor("ageTxt")
            val editTextCountry = createRefFor("countryTxt")
            val submitBtn = createRefFor("btn")


            constrain(editTextName) {
                top.linkTo(parent.top,20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height= Dimension.value(50.dp)
            }

            constrain(editTextAge) {
                top.linkTo(editTextName.bottom,12.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height= Dimension.value(50.dp)
            }
            constrain(editTextCountry) {
                top.linkTo(editTextAge.bottom,12.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height= Dimension.value(50.dp)
            }
            constrain(submitBtn) {
                top.linkTo(editTextCountry.bottom,12.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        }
        ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {

            TextField(
                value = nameTFState,
                onValueChange = { nameTFState = it },
                label = { Text("Enter Your Name") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxSize()
                    .layoutId("nameTxt")
            )

            TextField(
                value = ageTFState,
                onValueChange = { ageTFState = it },
                label = { Text("Enter Your Age") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxSize()
                    .layoutId("ageTxt")
            )


            TextField(
                value = countryTFState,
                onValueChange = { countryTFState = it },
                label = { Text("Enter Your Country") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxSize()
                    .layoutId("countryTxt")
            )

            Button(onClick = {},
                modifier = Modifier
                    .layoutId("btn")
                )
            {

                Text(text = "Submit")
            }
        }


    }
}

