package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.kavyakanaja.data.repository.kannadaPoets
import com.example.kavyakanaja.ui.components.PoetCard
import com.example.kavyakanaja.viewmodel.PoemViewModel

@Composable
fun AuthorsScreen(
    navController: NavHostController,
    viewModel: PoemViewModel
) {
    LazyColumn {

        items(kannadaPoets) { poet ->

            PoetCard(poet = poet) {
                navController.navigate("author_detail/${poet.name}")
            }
        }
    }
}