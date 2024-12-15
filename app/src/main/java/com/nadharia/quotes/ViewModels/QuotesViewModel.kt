package com.nadharia.quotes.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nadharia.quotes.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: QuotesRepository) : ViewModel() {

    val categories: StateFlow<List<String>>
        get() = repository. categories


    init {
        viewModelScope.launch {
            repository.getCategories()

        }
    }
}
