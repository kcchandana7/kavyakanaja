package com.example.kavyakanaja.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nameEnglish: String,
    val nameKannada: String,
    val bio: String,
    val era: String,
    val notablePoemCount: Int
)