package com.doordash.android.test.repository

import com.doordash.anroid.repository.api.DoordashApi
import com.doordash.anroid.model.DoordashRestaurant
import com.doordash.anroid.util.BASE_URL
import com.doordash.anroid.util.LATITUDE
import com.doordash.anroid.util.LONGITUDE
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.observers.TestObserver
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DoorDashServiceTest {

    private val mockWebServer = MockWebServer()
    private lateinit var doorDashApi:DoordashApi
    private val  INVALID_LATITUDE = -100000000.0
    private val INVALID_LONGITUDE = -100000000.0


    @Before
    fun setUp() {
        mockWebServer.start()
        doorDashApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url(BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DoordashApi::class.java)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testConnectionSuccess() {
        val testObservable = TestObserver<Response<List<DoordashRestaurant>>>()
        doorDashApi.getRestaurantList(LATITUDE, LONGITUDE)
            .subscribe(testObservable)
        testObservable.assertNoErrors()
        val response = testObservable.values()[0]
        assertTrue(response.code() == 200)
    }

    @Test
    fun testNoDataFound() {
        val testObservable = TestObserver<Response<List<DoordashRestaurant>>>()
        doorDashApi.getRestaurantList(INVALID_LATITUDE, INVALID_LONGITUDE)
            .subscribe(testObservable)
        val response = getProperResponse(testObservable)
        assertTrue(response.body() == null)
    }


    @Test
    fun testGetRestaurantList() {
        val testObservable = TestObserver<Response<List<DoordashRestaurant>>>()
        doorDashApi.getRestaurantList(LATITUDE, LONGITUDE)
            .subscribe(testObservable)
        val response = getProperResponse(testObservable)
        assertTrue(response.body()?.isEmpty() == false)
    }

    private fun getProperResponse(testObservable: TestObserver<Response<List<DoordashRestaurant>>>): Response<List<DoordashRestaurant>> {
        testObservable.assertNoErrors()
        val response = testObservable.values()[0]
        return response
    }



}