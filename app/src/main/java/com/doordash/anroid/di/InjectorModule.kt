package com.doordash.anroid.di

import com.doordash.anroid.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InjectorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun mainActivity(): MainActivity

}
