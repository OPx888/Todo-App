package com.prakash.clario

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.Date

data class ToDo(
	var id : Int ,
	var title : String,
	var createdAt : Date
)


@Composable
fun FakeList(modifier: Modifier = Modifier) : List<ToDo> {
	return listOf (
		ToDo(1, "Task 1", Date()),
		ToDo(2, "Task 2", Date()),
		ToDo(3, "Task 3", Date()),
		ToDo(4, "Task 4", Date()),
		ToDo(5, "Task 5", Date()),
		ToDo(6, "Task 6", Date()),
		ToDo(7, "Task 7", Date()),
		ToDo(8, "Task 8", Date()),
		ToDo(9, "Task 9", Date()),
		ToDo(10, "Task 10", Date()),
		ToDo(11, "Task 11", Date()),
		ToDo(12, "Task 12", Date()),
		ToDo(13, "Task 13", Date()),
		ToDo(14, "Task 14", Date()),
		ToDo(15, "Task 15", Date()),
		ToDo(16, "Task 16", Date()),
		ToDo(17, "Task 17", Date()),
	)
}