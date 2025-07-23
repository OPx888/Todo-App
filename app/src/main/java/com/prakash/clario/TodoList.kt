package com.prakash.clario

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prakash.clario.authview.AuthViewModel
import java.text.SimpleDateFormat

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ToDoList(modifier: Modifier = Modifier, viewModel : AuthViewModel) {
	val list by viewModel.todo.observeAsState()
	var task by remember { mutableStateOf("") }
	Column(
		modifier = Modifier
			.fillMaxHeight()
			.padding(8.dp,top = 50.dp)
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp),
			horizontalArrangement = Arrangement.spacedBy(8.dp),
			verticalAlignment = Alignment.CenterVertically
		){
			OutlinedTextField(
				value = task,
				onValueChange = { task = it },
				label = { Text("Enter Task") },
				modifier = Modifier.weight(1f)
			)
			Button(
				onClick = {
					viewModel.addToDo(task)
					task = ""
				}
			) {
				Text(text = "Add")
			}

		}
		list?.let{
			LazyColumn(
				content = {
					itemsIndexed(it) { index, item ->
						ListView(item = item, onDelete = { viewModel.deleteToDo(id = item.id ) })
					}
				}
			)
		}

	}

}

@Composable
fun ListView(item: ToDo , onDelete : () -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp)
			.clip(shape = RoundedCornerShape(16.dp))
			.background(color = Color.Black)
			.padding(16.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Column(
			modifier = Modifier.weight(1f)
		) {
			Text(
				text = SimpleDateFormat("HH:mm:aa dd/MM").format(item.createdAt),
				fontSize = 12.sp,
				color = Color.White
			)
			Text(
				text = item.title,
				fontSize = 20.sp,
				color = Color.White
			)
		}
		IconButton(
			onClick = {
				onDelete()
			},
		) {
			Icon(
				painter = painterResource(id = R.drawable.baseline_delete_24),
				contentDescription = null,
				tint = Color.White

			)
		}
	}

}