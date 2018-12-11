package com.doordash.anroid.repository.api

import com.doordash.anroid.model.DoordashRestaurant
import com.doordash.anroid.model.DoordashRestaurantDetail
import com.doordash.anroid.util.LIMIT
import com.doordash.anroid.util.OFFSET
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DoordashApi {

  @GET("/v2/restaurant/")
  fun getRestaurantList(
    @Query("lat") lat: Double,
    @Query("lng") lng: Double,
    @Query("offset") offset: Int = OFFSET, // default can be overwritten
    @Query("limit") limit: Int = LIMIT // default can be overwritten
  ): Observable<Response<List<DoordashRestaurant>>>

  @GET("/v2/restaurant/")
  fun getResultDetail(@Path("restaurant_id") restaurantId: Int
  ): Observable<Response<DoordashRestaurantDetail>>

}