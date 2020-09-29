package com.example.coronainfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.coronainfo.ui.CoronaInfoTheme
import com.example.coronainfo.ui.countrylist.CountryListScreen
import com.example.coronainfo.ui.countrylist.CountryListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.inject

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    val countryListViewModel: CountryListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoronaInfoTheme {
                // A surface container using the 'background' color from the theme
                CoronaInfoApp(countryListViewModel = countryListViewModel)
            }
        }
    }
}

@ExperimentalCoroutinesApi
@Composable
fun CoronaInfoApp(countryListViewModel: CountryListViewModel) {
    CountryListScreen(viewModel = countryListViewModel)
}
