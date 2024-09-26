package com.example.odcviewmodelexample.ui.screens.firstscreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

private const val TAG = "FirstScreen"
@Preview(showSystemUi = true,showBackground = true, device = "id:pixel_7")
@Composable
fun FirstScreen(viewModel: FirstScreenViewModel = viewModel()){
    val list = viewModel.list
    val number by viewModel.valueState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.valueState.collect{
            Log.d(TAG, "FirstScreen: $it")

        }

    }

    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
      items(list){
          Text(it.toString(), color = Color.Blue)
      }
       item {
           Text(number.toString(), color = Color.Red)
       }

    }



}