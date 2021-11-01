package com.example.stockholmtoromev2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qIndex_table")
data class Qindex(
    @PrimaryKey(autoGenerate = true) val id: MutableList<Qindex>,
    @ColumnInfo(name = "current") var current: Int,
    @ColumnInfo(name = "border") var border: Int,
    @ColumnInfo(name = "lastChance") var lastChance: Int,
    @ColumnInfo(name = "name") var name: String,)