package com.example.kavyakanaja.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kavyakanaja.data.model.Poem

@Composable
fun PoemItem(
    poem: Poem,
    onFavoriteClick: (Poem) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Text(text = poem.titleKannada, style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = poem.content)

            Spacer(modifier = Modifier.height(10.dp))

            Icon(
                imageVector =
                    if (poem.isFavorite)
                        Icons.Filled.Favorite
                    else
                        Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite",
                tint = if (poem.isFavorite) Color.Red else Color.Gray,
                modifier = Modifier.clickable {
                    onFavoriteClick(poem)
                }
            )
        }
    }
}