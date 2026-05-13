package com.example.kavyakanaja.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kavyakanaja.ui.components.BottomBar
import com.example.kavyakanaja.ui.components.TopBar
import com.example.kavyakanaja.ui.screens.*
import com.example.kavyakanaja.viewmodel.PoemViewModel
import com.example.kavyakanaja.ui.screens.PoemScreen

@Composable
fun AppNavGraph(
    viewModel: PoemViewModel
) {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val title = when (currentRoute) {
        Routes.HOME -> "Home"
        Routes.LIBRARY -> "Library"
        Routes.FAVORITES -> "Favorites"
        Routes.AUTHORS -> "Authors"
        Routes.POEM_OF_DAY -> "Poem of the Day"
        Routes.ADD_POEM -> "Add Poem"
        else -> "Kavyakanaja"
    }

    val containerColor = when (currentRoute) {
        Routes.HOME -> MaterialTheme.colorScheme.primary
        Routes.LIBRARY -> MaterialTheme.colorScheme.secondary
        Routes.FAVORITES -> MaterialTheme.colorScheme.tertiary
        Routes.AUTHORS -> MaterialTheme.colorScheme.primaryContainer
        Routes.POEM_OF_DAY -> MaterialTheme.colorScheme.inversePrimary
        Routes.ADD_POEM -> MaterialTheme.colorScheme.secondaryContainer
        else -> MaterialTheme.colorScheme.primary
    }

    val contentColor = MaterialTheme.colorScheme.onPrimary

    Scaffold(
        topBar = {
            TopBar(
                title = title,
                navController = navController,
                showBack = currentRoute != Routes.HOME,
                containerColor = containerColor,
                contentColor = contentColor
            )
        },
        bottomBar = {
            BottomBar(navController, currentRoute)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(padding)
        ) {

            composable(Routes.HOME) {
                HomeScreen(navController, viewModel)
            }

            composable(Routes.LIBRARY) {
                LibraryScreen(navController, viewModel)
            }

            composable(Routes.FAVORITES) {
                FavoritesScreen(navController, viewModel)
            }

            composable(Routes.AUTHORS) {
                AuthorsScreen(navController, viewModel)
            }

            composable(Routes.POEM_OF_DAY) {
                PoemOfDayScreen(navController, viewModel)
            }

            composable(Routes.ADD_POEM) {
                AddPoemScreen(navController, viewModel)
            }

            composable("author_detail/{name}") { backStackEntry ->

                val encodedName = backStackEntry.arguments?.getString("name") ?: ""
                val name = java.net.URLDecoder.decode(encodedName, "UTF-8")

                AuthorDetailScreen(name)
            }
            @Composable
            fun AppNavGraph(viewModel: PoemViewModel) {
                NavHost(
                    navController = rememberNavController(),
                    startDestination = "home"
                ) {
                    composable("poem_screen") {
                        PoemScreen(viewModel)
                    }
                }

                }
            }
        }
    }