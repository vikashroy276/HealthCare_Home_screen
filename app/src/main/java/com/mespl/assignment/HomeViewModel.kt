package com.mespl.assignment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mespl.assignment.data.repository.Repository

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    fun loadData() {
        uiState = repository.loadHomeData()
    }
}
