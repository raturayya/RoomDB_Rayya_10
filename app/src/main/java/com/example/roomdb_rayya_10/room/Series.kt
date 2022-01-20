package com.example.roomdb_rayya_10.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Series (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tittle: String,
    val desc: String
    )