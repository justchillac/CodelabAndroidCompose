package com.example.basicstatecodelab1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
//        WaterCounter(modifier)
        item{
            StatefulCounter(modifier)
        }

        val list = getWellnessTasks().toMutableStateList()
        //Using mutable objects for this, such as ArrayList<T> or mutableListOf, won't work.
        // These types won't notify Compose that the items in the list have changed and schedule a
        // recomposition of the UI.
        //Instead You need to create an instance of MutableList that is observable by Compose.
//        The extension function toMutableStateList() is the way to create an observable MutableList
//        from an initial mutable or immutable Collection, such as List.
//        Alternatively, you could also use the factory method mutableStateListOf

//        If you try to use rememberSaveable() to store the list in WellnessScreen,
//        you'll get a runtime exception
//        This error tells you that you need to provide a custom saver.

    }
}
