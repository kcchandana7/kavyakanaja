package com.example.kavyakanaja.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kavyakanaja.data.repository.PoemRepository
import com.example.kavyakanaja.viewmodel.PoemViewModel

class PoemViewModelFactory(
    private val repository: PoemRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PoemViewModel::class.java)) {
            return PoemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}