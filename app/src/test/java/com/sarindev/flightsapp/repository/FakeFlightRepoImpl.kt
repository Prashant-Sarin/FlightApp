package com.sarindev.flightsapp.repository

import com.sarindev.flightsapp.model.FlightModel
import com.sarindev.flightsapp.network.NetworkResponse

class FakeFlightRepoImpl: FlightRepo {

    private val flightList = ArrayList<FlightModel>()

    override suspend fun fetchFlights(): NetworkResponse<ArrayList<FlightModel>> {
        flightList.add(
            FlightModel(
                "5:00", "2/10/21", "4:00",
                "Goa", "AI 503", "Air India", "Bangalore", 5450
            )
        )
        flightList.add(
            FlightModel(
                "7:00", "2/10/21", "4:30",
                "Goa", "AI 503", "Air India", "Delhi", 5850
            )
        )
        flightList.add(
            FlightModel(
                "7:30", "2/10/21", "5:00",
                "Goa", "AI 503", "Air India", "Chandigarh", 6450
            )
        )
        return NetworkResponse.Success(flightList)
    }
}