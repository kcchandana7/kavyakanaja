package com.example.kavyakanaja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.kavyakanaja.data.db.AppDatabase
import com.example.kavyakanaja.data.repository.PoemRepository
import com.example.kavyakanaja.navigation.AppNavGraph
import com.example.kavyakanaja.ui.theme.KavyaKanajaTheme
import com.example.kavyakanaja.ui.viewmodel.PoemViewModelFactory
import com.example.kavyakanaja.viewmodel.PoemViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: PoemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DAO
        val dao = AppDatabase.getDatabase(applicationContext).poemDao()

        // Repository
        val repository = PoemRepository(dao)

        // Factory
        val factory = PoemViewModelFactory(repository)

        // ViewModel
        viewModel = ViewModelProvider(this, factory)[PoemViewModel::class.java]

        setContent {
            KavyaKanajaTheme {
                AppNavGraph(viewModel)
            }
        }
    }
}