package com.example.firstprojectwithjetpackcompose.features.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(navController: NavHostController) {

    var textFieldState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        TextField(
            value = textFieldState,
            onValueChange = {
                textFieldState = it
            },
            label = {
                Text("Search News....")
            },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }

}