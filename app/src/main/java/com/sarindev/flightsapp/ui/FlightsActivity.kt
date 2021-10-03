package com.sarindev.flightsapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sarindev.flightsapp.R
import com.sarindev.flightsapp.databinding.ActivityMainBinding
import com.sarindev.flightsapp.di.ViewModelProviderFactory
import com.sarindev.flightsapp.viewmodel.FlightsViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class FlightsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private var viewModel: FlightsViewModel? = null

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, providerFactory).get(FlightsViewModel::class.java)
        binding?.model = viewModel
        binding?.executePendingBindings()
        registerObservers()
        viewModel?.fetchFlights()
    }

    private fun registerObservers(){
        viewModel?.selectedFlight?.observe(this, {
            Toast.makeText(this,"selected Flight - ${it.flightNo}",Toast.LENGTH_SHORT).show()
        })
    }

    fun showMenu(v: View) {
        PopupMenu(this, v).apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.btn_price -> viewModel?.sortByPrice()
                    else -> viewModel?.sortByTime()
                }
                true
            }
            inflate(R.menu.sort_menu)
            show()
        }
    }


}