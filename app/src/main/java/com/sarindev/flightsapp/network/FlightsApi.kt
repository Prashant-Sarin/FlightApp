package com.sarindev.flightsapp.network

import com.sarindev.flightsapp.model.FlightModel
import retrofit2.Response
import retrofit2.http.GET

interface FlightsApi {

    @GET("/flightdata")
    suspend fun getFlights(): Response<ArrayList<FlightModel>>

}