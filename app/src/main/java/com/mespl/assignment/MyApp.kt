package com.mespl.assignment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.mespl.assignment.data.repository.Repository

@Composable
fun MyApp() {

    val context = LocalContext.current

    val repository = remember { Repository(context) }

    val viewModel = remember { HomeViewModel(repository) }

    HomeScreen(viewModel = viewModel)
}
