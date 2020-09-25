package com.androiddevs.ktornoteapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/*
    Define type converter

    WE need this because Note entity contains a list of type String which is not a primitive data type.
    Room does not know how to work with this it only knows how to persist primitive types.
    We need a way to convert this list to a String so room can use it and then convert it back to a list for the program
 */
class Converters {

    @TypeConverter
    fun fromList(list: List<String>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(string: String) : List<String> {
        return Gson().fromJson(string, object: TypeToken<List<String>>() { }.type) //(to convert, this type)
    }

}