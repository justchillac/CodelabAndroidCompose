package com.example.basicstatecodelab1

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically) {
        Text(modifier = Modifier.padding(start = 16.dp).weight(1f)
            ,text = taskName)
        IconButton(onClick = onClose) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}

@Preview
@Composable
fun WellnessTaskItemPreview(){
    WellnessTaskItem(taskName = "Task 1",
        onClose = {})
}
