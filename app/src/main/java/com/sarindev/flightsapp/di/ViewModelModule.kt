package com.sarindev.flightsapp.di

import androidx.lifecycle.ViewModel
import com.sarindev.flightsapp.viewmodel.FlightsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FlightsViewModel::class)
    abstract fun bindFlightsViewModel(flightsViewModel: FlightsViewModel): ViewModel
}