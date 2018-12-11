package com.doordash.android.test.viewmodel

import android.content.SharedPreferences
import com.doordash.anroid.repository.api.DoordashApi
import com.doordash.anroid.viewmodel.SearchResultListViewModel
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class SearchResultListViewModelTest {

    @Mock
    lateinit var doordashApi: DoordashApi

    @Mock
    lateinit var sharedPreferences: SharedPreferences

    var searchResultListViewModel: SearchResultListViewModel? = null


    @Before
    fun setUp() {
        doordashApi = Mockito.mock(DoordashApi::class.java)
        sharedPreferences = Mockito.mock(SharedPreferences::class.java)
        searchResultListViewModel = SearchResultListViewModel(doordashApi, sharedPreferences)
    }

    @Test
    fun testHandleRestaurantListDisposable() {
        assertTrue(searchResultListViewModel?.compositeDisposable != null)
    }

    @Test
    fun testIsErrorVisible() {
        assertTrue(searchResultListViewModel?.isErrorViewVisible?.get() == false)
    }

    @Test
    fun testIsWelcomeViewVisible() {
        assertTrue(searchResultListViewModel?.isWelcomeViewVisible?.get() == true)
    }

    @Test
    fun testIsLoadingProgressbarVisible() {
        assertTrue(searchResultListViewModel?.isLoadingProgressbarVisible?.get() == false)
    }


}