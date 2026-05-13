package com.example.kavyakanaja.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kavyakanaja.data.model.Poem
import com.example.kavyakanaja.data.repository.PoemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PoemViewModel(
    private val repository: PoemRepository
) : ViewModel() {

    // ALL POEMS
    val poems: Flow<List<Poem>> = repository.getAllPoems()

    // INSERT
    fun insertPoem(poem: Poem) {
        viewModelScope.launch {
            repository.insertPoem(poem)
        }
    }

    // UPDATE FAVORITE
    fun updateFavoriteStatus(poem: Poem) {
        viewModelScope.launch {
            repository.updatePoem(
                poem.copy(isFavorite = !poem.isFavorite)
            )
        }
    }

    // BY AUTHOR
    fun getPoemsByAuthor(authorId: Int): Flow<List<Poem>> {
        return repository.getPoemsByAuthor(authorId)
    }

    // BY ID
    fun getPoemById(poemId: Int): Flow<Poem> {
        return repository.getPoemById(poemId)
    }

    // DELETE
    fun deletePoem(poem: Poem) {
        viewModelScope.launch {
            repository.deletePoem(poem)
        }
    }
}