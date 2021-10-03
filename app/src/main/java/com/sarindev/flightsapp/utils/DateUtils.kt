package com.sarindev.flightsapp.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun getTimeDifference(startTime: String, endTime: String): String {
        val simpleDateFormat = SimpleDateFormat("hh:mm")
        val startTimeStamp = simpleDateFormat.parse(startTime)
        val endTimeStamp = simpleDateFormat.parse(endTime)
        val diff = (endTimeStamp.time - startTimeStamp.time) / 1000
        val minutes = (diff / 60) % 60
        val hours = (diff / (60 * 60)) % 24
        Log.d("DateUtils", "diff = $diff, minutes = $minutes, hours = $hours")
        return if (hours > 0)
            hours.toString().plus("hr ").plus(" $minutes").plus("min")
        else minutes.toString().plus("min")
    }

    fun getTimeStamp(time: String): Date {
        val simpleDateFormat = SimpleDateFormat("hh:mm")
        return simpleDateFormat.parse(time)
    }
}