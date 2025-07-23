package com.prakash.clario.authview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.prakash.clario.ToDo
import java.sql.Date
import java.time.Instant

object ToDoManager {
	private val todoList = mutableListOf<ToDo>()

	fun getAllToDo() : List<ToDo >{
		return todoList
	}

	@RequiresApi(Build.VERSION_CODES.O)
	fun addToDo(title : String){
		todoList.add(ToDo(System.currentTimeMillis().toInt(),title,Date.from(Instant.now())))
	}

	fun deleteToDo(id : Int){
		todoList.removeIf{
			it.id == id

		}
	}
}