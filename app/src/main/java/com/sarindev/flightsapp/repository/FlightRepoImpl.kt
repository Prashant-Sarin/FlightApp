package com.sarindev.flightsapp.repository

import com.sarindev.flightsapp.model.FlightModel
import com.sarindev.flightsapp.network.FlightsApi
import com.sarindev.flightsapp.network.NetworkResponse

class FlightRepoImpl(private val flightsApi: FlightsApi): FlightRepo {

    override suspend fun fetchFlights(): NetworkResponse<ArrayList<FlightModel>> {
        val result = flightsApi.getFlights()

        if (result.isSuccessful){
            result.body()?.let {
                return NetworkResponse.Success(it)
            }?: return NetworkResponse.Error(result.errorBody().toString())
        }else{
            return NetworkResponse.Error(result.errorBody().toString())
        }
    }
}