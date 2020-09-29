package com.example.coronainfo.ui.countrylist

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScope.weight
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.coronainfo.data.Country
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun CountryListScreen(viewModel: CountryListViewModel) {
    val state = viewModel.countriesState.collectAsState()
    LazyColumnForIndexed(
        items = state.value,
        modifier = Modifier.weight(1f),
        contentPadding = PaddingValues(top = 8.dp)
    ) { index, country ->
        Country(
            country,
            Modifier.fillParentMaxWidth()
        )
    }
}

@Composable
fun Country(country: Country, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(bottom = 8.dp)) {
        CountryListItem(
            country = country,
        )
    }
}

@Composable
fun CountryListItem(country: Country) {
    Card(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp, 8.dp),
    ) {
        Column(
            modifier = Modifier.padding(
                8.dp
            )
        ) {
            Text(
                text = country.name ?: "placeholder title",
                style = MaterialTheme.typography.subtitle2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(text = "Last update: ${country.lastUpdate}", style = MaterialTheme.typography.body2)
            Text(text = "Confirmed: ${country.confirmed}", style = MaterialTheme.typography.body2)
            Text(text = "Recovered: ${country.recovered}", style = MaterialTheme.typography.body2)
            Text(text = "New confirmed: ${country.newConfirmed}", style = MaterialTheme.typography.body2)
            Text(text = "New deaths: ${country.newDeaths}", style = MaterialTheme.typography.body2)
        }
    }
}