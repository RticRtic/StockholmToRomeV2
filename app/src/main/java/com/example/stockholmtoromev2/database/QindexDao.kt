package com.example.stockholmtoromev2.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QindexDao {

        @Insert
        fun insert(index: Qindex)

        @Delete
        fun delete(index: Qindex)

        @Query("SELECT * FROM qIndex_table")
        fun getAll() : List<Qindex>
}