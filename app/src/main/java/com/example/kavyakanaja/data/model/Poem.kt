package com.example.kavyakanaja.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poems")
data class Poem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String,
    val author: String,
    val titleKannada: String,
    val titleEnglish: String,
    val authorId: Int,
    val category: String,
    val isFavorite: Boolean = false
)
