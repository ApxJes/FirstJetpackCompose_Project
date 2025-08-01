package com.example.firstprojectwithjetpackcompose.features.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstprojectwithjetpackcompose.core.Resource
import com.example.firstprojectwithjetpackcompose.features.domain.useCase.BreakingNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(
    private val breakingNewsUseCase: BreakingNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BreakingNewsUiState())
    val uiState: StateFlow<BreakingNewsUiState> = _uiState.asStateFlow()

    init {
        getBreakingNews()
    }

    private fun getBreakingNews() {
        viewModelScope.launch {
            breakingNewsUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = true,
                            error = null
                        )
                    }
                    is Resource.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            articles = result.data ?: emptyList()
                        )
                    }
                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            error = result.message ?: "Unknown error"
                        )
                    }
                }
            }
        }
    }
}
