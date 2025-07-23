package com.prakash.clario.DB

import android.widget.DatePicker
import androidx.room.TypeConverter
import java.sql.Date

class Convertor {
	@TypeConverter
	fun fromDate (date : Date) : Long{
		return date.time

	}

	@TypeConverter
	fun toDate (time : Long) : Date{
		return Date(time)

	}
}