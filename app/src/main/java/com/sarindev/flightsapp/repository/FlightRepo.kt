package com.sarindev.flightsapp.repository

import com.sarindev.flightsapp.model.FlightModel
import com.sarindev.flightsapp.network.NetworkResponse

interface FlightRepo {
    suspend fun fetchFlights(): NetworkResponse<ArrayList<FlightModel>>
}