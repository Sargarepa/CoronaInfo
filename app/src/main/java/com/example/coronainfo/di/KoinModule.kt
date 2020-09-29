package com.example.coronainfo.di

import com.example.coronainfo.data.CountryRepository
import com.example.coronainfo.network.provideApolloClient
import com.example.coronainfo.ui.countrylist.CountryListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single { provideApolloClient() }
}

val repositoriesModule = module {
    factory { CountryRepository() }
}

@ExperimentalCoroutinesApi
val viewModelsModule = module {
    viewModel {  CountryListViewModel() }
}