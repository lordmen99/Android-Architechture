package com.example.androidarchitecture.room_dao_recyclerview;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("Delete FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority desc")
    LiveData<List<Note>> getAllNotes();
}
