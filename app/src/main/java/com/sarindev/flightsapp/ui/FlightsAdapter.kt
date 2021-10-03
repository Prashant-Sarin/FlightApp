package com.sarindev.flightsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarindev.flightsapp.databinding.AdapterFlightItemBinding
import com.sarindev.flightsapp.model.FlightModel
import com.sarindev.flightsapp.viewmodel.FlightsViewModel

class FlightsAdapter( val model: FlightsViewModel):RecyclerView.Adapter<FlightsAdapter.FlightsHolder>() {

    private var flightList = ArrayList<FlightModel>()

    inner class FlightsHolder(private val adapterFlightItemBinding: AdapterFlightItemBinding):
        RecyclerView.ViewHolder(adapterFlightItemBinding.root){
        fun bind(model: FlightsViewModel, flightModel: FlightModel){
            adapterFlightItemBinding.model = model
            adapterFlightItemBinding.item = flightModel
            adapterFlightItemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightsHolder {
        val viewBinding =  AdapterFlightItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FlightsHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: FlightsHolder, position: Int) {
        holder.bind(model, flightList[position])
    }

    override fun getItemCount() = flightList.size

    fun updateList(flights: ArrayList<FlightModel>){
        this.flightList.clear()
        this.flightList.addAll(flights)
        notifyDataSetChanged()
    }
}