package com.prakash.clario

import android.app.Application
import androidx.room.Room
import kotlin.jvm.java
import com.prakash.clario.DB.TodoDatabase

class MainApplication : Application() {

	companion object {
		lateinit var todoDatabase : TodoDatabase
	}

	override fun onCreate() {
		super.onCreate()
		todoDatabase = Room.databaseBuilder(
			applicationContext,
			TodoDatabase::class.java,
			TodoDatabase.NAME
		).build()

	}


}