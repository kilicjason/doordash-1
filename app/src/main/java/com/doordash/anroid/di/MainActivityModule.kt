package com.doordash.anroid.di


import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProviders
import com.doordash.anroid.viewmodel.SearchResultListViewModel
import com.doordash.anroid.repository.api.DoordashApi
import com.doordash.anroid.ui.MainActivity
import com.doordash.anroid.viewmodel.SearchResultListViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    internal fun provideViewModelFactory(
        doordashApi: DoordashApi,
        preferences: SharedPreferences
    ): SearchResultListViewModelFactory {
        return SearchResultListViewModelFactory(
            doordashApi, preferences
        )
    }

    @Provides
    @ActivityScope
    internal fun provideViewModel(
        activity: MainActivity,
        factory: SearchResultListViewModelFactory
    ): SearchResultListViewModel {
        return ViewModelProviders.of(activity, factory).get(SearchResultListViewModel::class.java)
    }

}