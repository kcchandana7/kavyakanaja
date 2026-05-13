package com.example.kavyakanaja.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kavyakanaja.data.db.AppDatabase
import com.example.kavyakanaja.data.model.Author
import com.example.kavyakanaja.data.repository.AuthorRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuthorViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AuthorRepository

    val allAuthors: StateFlow<List<Author>>

    init {
        val dao = AppDatabase.getDatabase(application).authorDao()
        repository = AuthorRepository(dao)

        allAuthors = repository.getAllAuthors()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }

    fun insertAuthor(author: Author) {
        viewModelScope.launch {
            repository.insertAuthor(author)
        }
    }

    fun insertAuthors(authors: List<Author>) {
        viewModelScope.launch {
            repository.insertAuthors(authors)
        }
    }

    // ✅ Better approach (recommended)
    suspend fun getAuthorById(id: Int) = repository.getAuthorById(id)
}