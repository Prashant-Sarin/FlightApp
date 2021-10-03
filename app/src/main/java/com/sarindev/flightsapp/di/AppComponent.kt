package com.sarindev.flightsapp.di

import android.app.Application
import com.sarindev.flightsapp.common.FlightsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, AppModule::class, ViewModelFactoryModule::class,
        ViewModelModule::class, ActivityBuilderModule::class, RepoModule::class
    ]
)
interface AppComponent : AndroidInjector<FlightsApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun Build(): AppComponent
    }
}