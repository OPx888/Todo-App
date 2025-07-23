package com.prakash.clario.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prakash.clario.ToDo

@Database(entities = [ToDo::class], version = 1)
@TypeConverters(Convertor::class)
abstract class TodoDatabase : RoomDatabase() {

	companion object{
		const val NAME = "Todo_DB"
	}

	abstract fun getTodoDao () : TodoDao
}