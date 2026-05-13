package com.example.kavyakanaja.data.repository

import com.example.kavyakanaja.data.dao.AuthorDao
import com.example.kavyakanaja.data.model.Author
import kotlinx.coroutines.flow.Flow

class AuthorRepository(private val dao: AuthorDao) {

    fun getAllAuthors(): Flow<List<Author>> = dao.getAllAuthors()

    fun getAuthorById(id: Int): Flow<Author> = dao.getAuthorById(id)

    suspend fun insertAuthor(author: Author) {
        dao.insertAuthor(author)
    }

    suspend fun insertAuthors(authors: List<Author>) {
        dao.insertAll(authors)
    }

    fun getAuthorCount(): Flow<Int> = dao.getAuthorCount()
}