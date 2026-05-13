package com.example.kavyakanaja.data.repository

import com.example.kavyakanaja.data.dao.PoemDao
import com.example.kavyakanaja.data.model.Poem
import kotlinx.coroutines.flow.Flow

class PoemRepository(private val dao: PoemDao) {

    // Get all poems
    fun getAllPoems(): Flow<List<Poem>> {
        return dao.getAllPoems()
    }

    // Get poems by author
    fun getPoemsByAuthor(authorId: Int): Flow<List<Poem>> {
        return dao.getPoemsByAuthor(authorId)
    }

    // Get single poem
    fun getPoemById(id: Int): Flow<Poem> {
        return dao.getPoemById(id)
    }

    // Insert poem
    suspend fun insertPoem(poem: Poem) {
        dao.insertPoem(poem)
    }

    // Update poem
    suspend fun updatePoem(poem: Poem) {
        dao.updatePoem(poem)
    }

    // Delete poem
    suspend fun deletePoem(poem: Poem) {
        dao.deletePoem(poem)
    }
}