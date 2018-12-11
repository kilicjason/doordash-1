package com.doordash.anroid.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doordash.anroid.repository.api.DoordashApi

class SearchResultListViewModelFactory(
    private val doordashApi: DoordashApi,
    private val preferences: SharedPreferences
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return SearchResultListViewModel(doordashApi, preferences) as T
    }
}