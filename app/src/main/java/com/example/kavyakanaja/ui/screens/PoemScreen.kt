package com.example.kavyakanaja.ui.screens
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.example.kavyakanaja.ui.components.PoemItem
import com.example.kavyakanaja.viewmodel.PoemViewModel

@Composable
fun PoemScreen(viewModel: PoemViewModel) {

    val lifecycleOwner = LocalLifecycleOwner.current

    val poems = viewModel.poems.collectAsStateWithLifecycle(
        initialValue = emptyList(),
        lifecycle = lifecycleOwner.lifecycle
    ).value

    LazyColumn {
        items(poems) { poem ->
            PoemItem(
                poem = poem,
                onFavoriteClick = {
                    viewModel.updateFavoriteStatus(it)
                }
            )
        }
    }
}