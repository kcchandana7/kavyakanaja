package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kavyakanaja.data.model.Author
import com.example.kavyakanaja.data.model.Poem
import com.example.kavyakanaja.viewmodel.PoemViewModel
import com.example.kavyakanaja.utils.SampleDataLoader.authors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPoemScreen(
    navController: NavHostController,
    viewModel: PoemViewModel
) {

    var titleEnglish by remember { mutableStateOf("") }
    var titleKannada by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }

    var selectedAuthor by remember { mutableStateOf<Author?>(null) }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Poem") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedTextField(
                value = titleEnglish,
                onValueChange = { titleEnglish = it },
                label = { Text("Title (English)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = titleKannada,
                onValueChange = { titleKannada = it },
                label = { Text("Title (Kannada)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Poem Content") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category") },
                modifier = Modifier.fillMaxWidth()
            )

            // AUTHOR DROPDOWN
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedAuthor?.nameEnglish ?: "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Select Author") },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    authors.forEach { author ->
                        DropdownMenuItem(
                            text = { Text(author.nameEnglish) },
                            onClick = {
                                selectedAuthor = author
                                expanded = false
                            }
                        )
                    }
                }
            }

            Button(
                onClick = {
                    val poem = Poem(
                        content = content,
                        author = selectedAuthor!!.nameEnglish,
                        titleKannada = titleKannada,
                        titleEnglish = titleEnglish,
                        authorId = selectedAuthor!!.id,
                        category = category,
                        isFavorite = false
                    )

                    viewModel.insertPoem(poem)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                enabled = titleEnglish.isNotBlank()
                        && content.isNotBlank()
                        && selectedAuthor != null
            ) {
                Text("Save Poem")
            }
        }
    }
}