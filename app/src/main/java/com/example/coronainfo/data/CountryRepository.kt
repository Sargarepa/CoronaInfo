package com.example.coronainfo.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.example.coronainfo.CountryListQuery
import org.koin.core.KoinComponent
import org.koin.core.inject

class CountryRepository : KoinComponent {

    private val apolloClient: ApolloClient by inject()

    suspend fun loadCountries(): List<Country> {
        return loadCountriesFromNetwork()
    }

    private suspend fun loadCountriesFromNetwork(): List<Country> {
        val response = apolloClient.query(CountryListQuery()).await()
        val countries = response.data?.summary?.countries
        return countries?.filterNotNull()?.map {
            it.toDomainModel()
        } ?: listOf()
    }
}