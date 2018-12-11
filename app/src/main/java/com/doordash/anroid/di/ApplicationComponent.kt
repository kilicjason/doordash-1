package com.doordash.anroid.di

import android.app.Application
import com.doordash.anroid.DoordashApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class,
        InjectorModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(doordashApp: DoordashApp)

    override fun inject(instance: DaggerApplication?)
}

