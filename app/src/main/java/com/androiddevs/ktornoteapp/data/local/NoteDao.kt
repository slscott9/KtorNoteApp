package com.androiddevs.ktornoteapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androiddevs.ktornoteapp.data.local.entities.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("delete from notes_table where id = :noteId")
    suspend fun deleteNoteById(noteId: String)

    @Query("delete from notes_table where isSynced == 1")
    suspend fun deleteAllSyncedNotes()

    @Query("select * from notes_table where id = :noteId")
    fun observeNoteById(noteId: String) : LiveData<Note>

    @Query("select * from notes_table where id = :noteId")
    suspend fun getNoteById(noteId: String) : Note?

    @Query("select * from notes_table order by date desc")
    fun getAllNotes() : Flow<List<Note>>

    @Query("select * from notes_table where isSynced = 0")
    suspend fun getAllUnSynchedNotes() : List<Note>
}