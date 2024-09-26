package com.example.odcviewmodelexample.ui.screens.firstscreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FirstScreenViewModel : ViewModel() {

    private val _list = mutableStateListOf<Int>()
    val list = _list

    private val _valueState = MutableStateFlow<Int>(0)
    val valueState = _valueState.asStateFlow()

    init {
        add(1)
        add(2)
        add(3)
        add(4)
        count()
    }

    private fun count(){
        viewModelScope.launch {
            val listNum = listOf(1,2,3,4,4,4,4,5)
            for (i in listNum){
                delay(1000)
                _valueState.value = i
            }
        }
    }

    private fun add(item: Int) {
        _list.add(item)
    }

}