package com.prakash.clario.authview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prakash.clario.ToDo

class AuthViewModel : ViewModel () {

	private val _todo = MutableLiveData<List<ToDo>>()
	val todo : LiveData<List<ToDo>> = _todo

	fun getAllToDo(){
		_todo.value = ToDoManager.getAllToDo().reversed()
	}

	@RequiresApi(Build.VERSION_CODES.O)
	fun addToDo(title : String){
		 ToDoManager.addToDo(title)
		 getAllToDo()
	}

	fun deleteToDo(id : Int){
		ToDoManager.deleteToDo(id)
		getAllToDo()

	}
}