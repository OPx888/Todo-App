package com.prakash.clario.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.prakash.clario.ToDo

@Dao
interface TodoDao{

	@Query("Select * from todo")
	fun getAllTodo() : LiveData<List<ToDo>>

	@Insert
	fun addTodo(todo : ToDo)

	@Query("Delete from todo where id = :id")
	fun deleteTodo(id : Int)
}