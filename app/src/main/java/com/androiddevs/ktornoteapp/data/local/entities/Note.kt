package com.androiddevs.ktornoteapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.util.*

@Entity(tableName = "notes_table")
data class Note (
    val title: String,
    val content: String,
    val date: Long,
    val owners: List<String>,
    val color: String,

    /*
        If the note has been synchronized or not is something we only save client side not server side
        Some owners notes could be synched and could not be synched we need a way to know this
     */
    @Expose(deserialize = false, serialize = false) //retrofit will ignore this parameter when parsing
    val isSynced: Boolean = false,

    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString()
)