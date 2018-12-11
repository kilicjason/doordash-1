package com.doordash.anroid

import android.app.Activity
import android.app.Application
import com.doordash.anroid.di.ApplicationComponent
import com.doordash.anroid.di.DaggerApplicationComponent
import dagger.android.*

import timber.log.Timber
import javax.inject.Inject

class DoordashApp : Application(), HasActivityInjector {

    private var applicationComponent: ApplicationComponent? = null


    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        injectApplication()
        initLibs()
    }


    fun injectApplication() {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()
        applicationComponent?.inject(this)
    }

    fun initLibs() {
        // Initialize Timber
        Timber.plant(Timber.DebugTree())
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityInjector
    }


}