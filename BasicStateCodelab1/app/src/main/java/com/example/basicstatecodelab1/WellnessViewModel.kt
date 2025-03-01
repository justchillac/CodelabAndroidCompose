package com.example.basicstatecodelab1

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

//The ViewModel instance is retained as long as the scope is alive.
//For example, if the composable is used in an activity, viewModel() returns the same instance
// until the activity is finished or the process is killed.

//ViewModels are recommended to be used at screen-level composables, that is, close to a root
//composable called from an activity, fragment, or destination of a Navigation graph. ViewModels
//should never be passed down to other composables, instead you should pass only the data they need
//and functions that perform the required logic as parameters.
class WellnessViewModel : ViewModel(){
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks : List<WellnessTask> get() = _tasks

    fun remove(item: WellnessTask){
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean){
        _tasks.find { it.id == item.id }?.let { task->
            task.checked = checked }
    }
}

//This method just generates fake data
private fun getWellnessTasks() = List(30){i->WellnessTask(i, "Task # $i")} //In a real app we get data from the
//data layer



