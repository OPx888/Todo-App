package com.prakash.clario.authview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prakash.clario.MainApplication
import com.prakash.clario.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Date
import java.time.Instant

class TodoViewModel : ViewModel () {



	val todoDao = MainApplication.todoDatabase.getTodo()
	val todo : LiveData<List<ToDo>> = todoDao.getAllTodo()


	@RequiresApi(Build.VERSION_CODES.O)
	fun addToDo(title : String){
		viewModelScope.launch(Dispatchers.IO){
			todoDao.addTodo(ToDo(title = title,createdAt = Date.from(Instant.now()) ))
		}
	}

	fun deleteToDo(id : Int){
		viewModelScope.launch(Dispatchers.IO){
			todoDao.deleteTodo(id)
		}

	}


//	To Do Manager Implementation
//	fun getAllToDo(){
//		_todo.value = ToDoManager.getAllToDo().reversed()
//	}
//
//	@RequiresApi(Build.VERSION_CODES.O)
//	fun addToDo(title : String){
//		 ToDoManager.addToDo(title)
//		 getAllToDo()
//	}
//
//	fun deleteToDo(id : Int){
//		ToDoManager.deleteToDo(id)
//		getAllToDo()
//
//	}


}