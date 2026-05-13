package com.example.kavyakanaja.ui

import androidx.compose.runtime.Composable
import com.example.kavyakanaja.navigation.AppNavGraph
import com.example.kavyakanaja.viewmodel.PoemViewModel

@Composable
fun KavyaKanajaApp(
    viewModel: PoemViewModel
) {
    // This file is now only the app root wrapper
    AppNavGraph(viewModel = viewModel)
}