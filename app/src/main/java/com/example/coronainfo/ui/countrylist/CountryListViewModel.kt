package com.example.coronainfo.ui.countrylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronainfo.data.Country
import com.example.coronainfo.data.CountryRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

@ExperimentalCoroutinesApi
class CountryListViewModel: ViewModel(), KoinComponent {

    private val repository: CountryRepository by inject()
    private val _countriesState = MutableStateFlow(listOf<Country>())

    val countriesState: StateFlow<List<Country>> get() = _countriesState

    init {
        loadCountries()
    }

    private fun loadCountries() {
        viewModelScope.launch {
            _countriesState.value = repository.loadCountries()
        }
    }
}