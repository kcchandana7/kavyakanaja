package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kavyakanaja.viewmodel.PoemViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: PoemViewModel
) {
    val poems by viewModel.poems.collectAsState(initial = emptyList())

    val todayPoem = poems.firstOrNull()

    val today = remember {
        SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        // HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF5C6BC0), Color(0xFF3949AB))
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                Text(
                    "📜 Kavya Kanaja",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(today, color = Color.White)
            }
        }

        Spacer(Modifier.height(16.dp))

        // POEM OF DAY
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(Modifier.padding(16.dp)) {

                Text("Poem of the Day ✨")

                Spacer(Modifier.height(10.dp))

                if (todayPoem != null) {
                    Text(todayPoem.titleKannada)
                    Spacer(Modifier.height(6.dp))
                    Text(todayPoem.content)
                } else {
                    Text("No poem available yet")
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // DASHBOARD
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DashboardButton("Favourites") {
                navController.navigate("favorites")
            }

            DashboardButton("Poets") {
                navController.navigate("authors")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DashboardButton("Add Poem") {
                navController.navigate("addPoem")   // FIXED ❌ add_poem → addPoem
            }

            DashboardButton("All Poems") {
                navController.navigate("library")    // FIXED ❌ poems → library
            }
        }
    }
}
@Composable
fun DashboardButton(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(160.dp)
            .height(90.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(title, style = MaterialTheme.typography.titleMedium)
        }
    }
}