package com.sarindev.flightsapp.di

import com.sarindev.flightsapp.common.Constants
import com.sarindev.flightsapp.network.FlightsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesFlightsApi(retrofit: Retrofit): FlightsApi{
        return retrofit.create(FlightsApi::class.java)
    }

}