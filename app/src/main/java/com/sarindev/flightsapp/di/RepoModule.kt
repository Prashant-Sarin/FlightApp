package com.sarindev.flightsapp.di

import com.sarindev.flightsapp.network.FlightsApi
import com.sarindev.flightsapp.repository.FlightRepo
import com.sarindev.flightsapp.repository.FlightRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun providesFlightRepo(flightsApi: FlightsApi): FlightRepo {
        return FlightRepoImpl(flightsApi)
    }
}