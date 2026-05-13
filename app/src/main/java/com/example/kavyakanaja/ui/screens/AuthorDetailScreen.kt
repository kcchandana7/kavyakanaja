package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kavyakanaja.data.repository.kannadaPoets

@Composable
fun AuthorDetailScreen(name: String) {

    val poet = kannadaPoets.find { it.name == name }

    poet?.let {

        Text(
            text = it.name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = it.bio,
            modifier = Modifier.padding(16.dp)
        )

    } ?: Text("Poet not found")
}