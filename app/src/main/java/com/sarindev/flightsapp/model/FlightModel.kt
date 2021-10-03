package com.sarindev.flightsapp.model

import android.os.Parcelable
import com.sarindev.flightsapp.utils.DateUtils
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class FlightModel(
    var arrivalTime: String? = null,
    var date: String? = null,
    var departureTime: String? = null,
    var destination: String? = null,
    var flightNo: String? = null,
    var name: String? = null,
    var origin: String? = null,
    var price: Long? = null
):Parcelable{

    fun getTravelTime(): String{
        return departureTime?.let { arrivalTime?.let { it1 -> DateUtils.getTimeDifference(it, it1) } } ?: ""
    }

    fun getDepartureTimeStamp(): Date?{
        return departureTime?.let { DateUtils.getTimeStamp(it) }
    }
}
