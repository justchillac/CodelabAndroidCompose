package com.example.basicstatecodelab1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//UI logic relates to how to display state changes on the screen
//business logic is what to do with state changes (for example making a payment
//ViewModels survive configuration changes, so they have a longer lifetime than the Composition
//it's a good practice to keep the UI logic and business logic separated from the UI state and migrate it to a ViewModel.

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
            var showTask by remember { mutableStateOf(true) }
//            var checkedState by remember { mutableStateOf(false) }
//            if(showTask){
//                WellnessTaskItem(taskName = "Have you taken your 15min walk today",
//                    checked = checkedState,
//                    onCheckedChange = {newValue -> checkedState = newValue},
//                    onClose = {showTask = false})
//            }
        Text(
            text = "You've had $count glasses"
        )
            }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                enabled = count < 10,  //This explains
                //            how State drives which elements are present in the UI at a given moment.
                onClick = { count++ }
            ) { Text(text = "Add one") }
            Button(onClick = {count = 0},
                Modifier
                    .padding(start = 8.dp)
                    .weight(1f)) {
                Text(text = "Clear water count")
            }
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, {count++}, modifier)
}

@Composable
fun StatelessCounter(count: Int, onIncrement: ()-> Unit, modifier: Modifier = Modifier){
    Column(modifier = Modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Preview
@Composable
fun WaterCounterPreview(){
    WaterCounter()
}

@Preview
@Composable
fun StatelessCounterPreview(){
    StatelessCounter(count = 0, onIncrement = {})
}

@Preview
@Composable
fun StatefulCounterPreview(){
    StatefulCounter()
}

