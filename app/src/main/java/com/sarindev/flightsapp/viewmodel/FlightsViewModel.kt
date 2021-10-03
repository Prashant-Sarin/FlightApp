package com.sarindev.flightsapp.viewmodel

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sarindev.flightsapp.model.FlightModel
import com.sarindev.flightsapp.network.NetworkResponse
import com.sarindev.flightsapp.repository.FlightRepo
import com.sarindev.flightsapp.ui.FlightsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FlightsViewModel@Inject constructor(private val flightRepo: FlightRepo) : ViewModel() {
    private val TAG = "FlightsViewModel"

    val flightsAdapter by lazy { FlightsAdapter(this) }
    var progressLoading = ObservableBoolean(false)
    var flights = ObservableArrayList<FlightModel>()

    private var _selectedFlight = MutableLiveData<FlightModel>()
    val selectedFlight = _selectedFlight


    fun fetchFlights(){
        viewModelScope.launch {
            progressLoading.set(true)
            val response = flightRepo.fetchFlights()
            if (response is NetworkResponse.Success){
                Log.d(TAG, "fetchFlights: api successful - ${response.data}")
                flights.clear()
                response.data?.let { flights.addAll(it) }
            }else{
                Log.e(TAG, "fetchFlights: error = ${response.message.toString()}" )
            }
            progressLoading.set(false)
        }
    }

    fun onFlightClicked(flightModel: FlightModel){
        Log.d(TAG,"onFlightClicked: flight = ${flightModel.flightNo}")
        _selectedFlight.postValue(flightModel)
    }
    
    fun sortByPrice(){
        Log.d(TAG, "sortByPrice: ")
        val sortedList = flights.sortedBy {
            it.price
        }
        flights.clear()
        flights.addAll(sortedList)
    }
    
    fun sortByTime(){
        Log.d(TAG, "sortByTime: ")
        val sortedList = flights.sortedBy {
            it.getDepartureTimeStamp()
        }
        flights.clear()
        flights.addAll(sortedList)
    }


    companion object{
        @JvmStatic
        @BindingAdapter("model", "flights")
        fun RecyclerView.showFlights(model: FlightsViewModel, flights: ArrayList<FlightModel>){
            adapter = model.flightsAdapter
            layoutManager = LinearLayoutManager(context)
            model.flightsAdapter.updateList(flights)
        }
    }
}