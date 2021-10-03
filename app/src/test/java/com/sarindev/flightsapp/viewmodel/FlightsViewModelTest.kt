package com.sarindev.flightsapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.androiddevs.shoppinglisttestingyt.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import com.sarindev.flightsapp.repository.FakeFlightRepoImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class FlightsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private var viewModel: FlightsViewModel? = null

    @Before
    fun setUp() {
        viewModel = FlightsViewModel(FakeFlightRepoImpl())
    }

    @After
    fun tearDown() {
        viewModel = null
    }

    @Test
    fun fetchFlights() {
        viewModel?.fetchFlights()
        assertThat(viewModel?.flights?.size).isGreaterThan(0)
    }

    @Test
    fun sortByPrice() {
        viewModel?.fetchFlights()
        viewModel?.sortByPrice()
        assertThat(viewModel?.flights?.get(0)?.price).isEqualTo(5450)
    }

    @Test
    fun sortByTime() {
        viewModel?.fetchFlights()
        viewModel?.sortByTime()
        assertThat(viewModel?.flights?.get(0)?.departureTime).isEqualTo("4:00")
    }
}