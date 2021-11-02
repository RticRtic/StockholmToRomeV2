package com.example.stockholmtoromev2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qIndex_table")
data class Qindex(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "current") var currentIndex: Int,
    @ColumnInfo(name = "name") var name: String)