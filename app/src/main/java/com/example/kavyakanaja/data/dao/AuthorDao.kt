package com.example.kavyakanaja.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kavyakanaja.data.model.Author
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {

    @Query("SELECT * FROM authors")
    fun getAllAuthors(): Flow<List<Author>>

    @Query("SELECT * FROM authors WHERE id = :id")
    fun getAuthorById(id: Int): Flow<Author>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthor(author: Author)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(authors: List<Author>)
    @Query("SELECT COUNT(*) FROM authors")
    fun getAuthorCount(): Flow<Int>
}