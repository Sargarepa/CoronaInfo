package com.example.coronainfo.data

import com.example.coronainfo.CountryListQuery

data class Country(
    val name: String?,
    val lastUpdate: String?,
    val confirmed: Int?,
    val recovered: Int?,
    val newConfirmed: Int?,
    val newDeaths: Int?
)

fun CountryListQuery.Country.toDomainModel() = Country(
    name = this.country_Region,
    lastUpdate = this.last_Update,
    confirmed = this.confirmed,
    recovered = this.recovered,
    newConfirmed = this.newConfirmed,
    newDeaths = this.newDeaths
)