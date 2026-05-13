package com.example.kavyakanaja.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
)
val items = listOf(
    BottomNavItem("home", "Home", Icons.Default.Home),
    BottomNavItem("library", "Library", Icons.Default.Book),
    BottomNavItem("favorites", "Favorites", Icons.Default.Favorite),
    BottomNavItem("authors", "Authors", Icons.Default.Person)
)