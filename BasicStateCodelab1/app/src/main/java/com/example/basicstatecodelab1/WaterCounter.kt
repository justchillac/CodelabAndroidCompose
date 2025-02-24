package com.example.basicstatecodelab1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable   //We refer to the Composition as the description of
// the UI built by Compose when it executes composables.
fun WaterCounter(modifier: Modifier = Modifier){   //with the new state, creating an updated UI—this
    // is called recomposition
//    Recomposition: re-running composables to update the Composition when data changes.
    //Key idea: State is. Events happen.
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }     //So this is what actually happens:
        //Any changes to the mutableState value triggers a recomposition to any functions associated
        //with the mutable value
        //But notice that without remember the last value of the mutableState will not be preserved
        //For example we can see that without remember the value of count will be set to 0 again
        //So to preserve the last mutated value we need to use the remember composable inline function
        if(count>0){
        Text(
            text = "You've had $count glasses"
        )
            }
        Button(enabled = if(count<10) true else false,  //This explains
//            how State drives which elements are present in the UI at a given moment.
            onClick = {count++},
            modifier = Modifier.padding(top = 8.dp)
        ) { Text(text = "Add one") }
    }
}

@Preview
@Composable
fun WaterCounterPreview(){
    WaterCounter()
}
