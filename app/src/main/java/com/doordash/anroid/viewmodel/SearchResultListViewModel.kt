package com.doordash.anroid.viewmodel

import android.content.SharedPreferences
import androidx.annotation.VisibleForTesting
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.doordash.anroid.repository.api.DoordashApi
import com.doordash.anroid.model.DoordashRestaurant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import timber.log.Timber


class SearchResultListViewModel(
    private val doordashApi: DoordashApi,
    private val preferences: SharedPreferences
) : ViewModel() {

    @VisibleForTesting
    val compositeDisposable = CompositeDisposable()
    val isRecyclerViewVisible = ObservableBoolean(false)
    val isNoDataFoundViewVisible = ObservableBoolean(false)
    val isErrorViewVisible = ObservableBoolean(false)
    val isWelcomeViewVisible = ObservableBoolean(true)
    val isLoadingProgressbarVisible = ObservableBoolean(false)
    val doordashRestaurantList = ObservableArrayList<DoordashRestaurant>()


    fun getRestaurantList(lat: Double, lng: Double, offset: Int, limit: Int) {
        updateVisibility(isProgressVisible = true)
        var disposable = doordashApi
            .getRestaurantList(lat, lng, offset, limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::handleRestaurantListSuccess,
                ::handleResponseFailure
            )
        compositeDisposable.add(disposable)
    }

    private fun handleRestaurantListSuccess(restaurantListResponse: Response<List<DoordashRestaurant>>) {
        if (isResponseSuccessful(restaurantListResponse) && !restaurantListResponse.body().isNullOrEmpty()) {
            updateVisibility(isListViewVisible = true)
            doordashRestaurantList.addAll(restaurantListResponse.body()!!)
        } else {
            updateVisibility(isNoDataVisible = true)
        }
    }

    private fun handleResponseFailure(error: Throwable) {
        updateViewVisibility()
        Timber.e(error)
    }

    private fun updateViewVisibility() {
        updateVisibility(isErrorVisible = true)
    }

    private fun updateVisibility(
        isNoDataVisible: Boolean = false, isErrorVisible: Boolean = false,
        isListViewVisible: Boolean = false, isProgressVisible: Boolean = false
    ) {
        isRecyclerViewVisible.set(isListViewVisible)
        isNoDataFoundViewVisible.set(isNoDataVisible)
        isLoadingProgressbarVisible.set(isProgressVisible)
        isWelcomeViewVisible.set(false) // hide after first interaction
        isErrorViewVisible.set(isErrorVisible)
    }

    private fun isResponseSuccessful(response: Response<*>): Boolean {
        return response.isSuccessful
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}