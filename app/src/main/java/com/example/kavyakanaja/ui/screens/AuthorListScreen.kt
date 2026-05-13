package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kavyakanaja.ui.viewmodel.AuthorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorListScreen(
    navController: NavHostController,
    viewModel: AuthorViewModel = viewModel()
) {

    val authors by viewModel.allAuthors.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(authors) { author ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("author_poems/${author.id}")
                    }
            ) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = author.nameEnglish,
                        style = MaterialTheme.typography.titleMedium
                    )

                    author.bio?.let {
                        Text(text = it.take(80) + "...")
                    }
                }
            }
        }
    }
}