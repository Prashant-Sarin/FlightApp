package com.sarindev.flightsapp.di

import com.sarindev.flightsapp.ui.FlightsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeFlightsActivity(): FlightsActivity
}