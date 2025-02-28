package com.example.basicstatecodelab1

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

//This method just generates fake data
fun getWellnessTasks() = List(30){i->WellnessTask(i, "Task # $i")} //In a real app we get data from the
//data layer

@Composable
fun WellnessTasksList(list: List<WellnessTask> = rememberSaveable {getWellnessTasks()},
                      onCloseTask: (WellnessTask)->Unit,
                      modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(items = list,
            key = {task->task.id}){task->
            WellnessTaskItem(taskName = task.label, onClose = {onCloseTask(task)})
        }
    }
}