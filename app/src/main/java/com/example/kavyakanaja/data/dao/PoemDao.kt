package com.example.kavyakanaja.data.dao

import androidx.room.*
import com.example.kavyakanaja.data.model.Poem
import kotlinx.coroutines.flow.Flow

@Dao
interface PoemDao {

    @Query("SELECT * FROM poems")
    fun getAllPoems(): Flow<List<Poem>>

    @Query("SELECT * FROM poems WHERE id = :id")
    fun getPoemById(id: Int): Flow<Poem>

    @Query("SELECT * FROM poems WHERE authorId = :authorId")
    fun getPoemsByAuthor(authorId: Int): Flow<List<Poem>>

    @Query("SELECT * FROM poems WHERE isFavorite = 1")
    fun getFavoritePoems(): Flow<List<Poem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoem(poem: Poem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(poems: List<Poem>)

    @Update
    suspend fun updatePoem(poem: Poem)

    @Delete
    suspend fun deletePoem(poem: Poem)
}