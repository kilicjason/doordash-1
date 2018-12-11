package com.doordash.anroid.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class ApplicationModule {

    @Provides
    @ApplicationScope
    fun providesContext(application: Application): Context {
        return application
    }

    @Provides
    @ApplicationScope
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

}