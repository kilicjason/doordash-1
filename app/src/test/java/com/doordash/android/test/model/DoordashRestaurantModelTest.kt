package com.doordash.android.test.model

import com.doordash.anroid.model.DoordashRestaurant
import com.doordash.anroid.util.EMPTY_STRING
import org.junit.Assert.assertTrue
import org.junit.Test


class DoordashRestaurantModelTest {

    @Test
    fun testNull() {
        val doordashRestaurant = DoordashRestaurant(name = null, deliveryFeeInCents = 0.0f,
            restaurantThumbnailUrl = null, id = 0, status = null, typeOfFood = null)
        assertTrue(doordashRestaurant.name == null)
    }

    @Test
    fun testEntity() {
        val dummyRestaurantName = "dummyRestaurantName"
        val doordashRestaurant = DoordashRestaurant(name = dummyRestaurantName, deliveryFeeInCents = 0.0f,
            restaurantThumbnailUrl = EMPTY_STRING, id = 0, status = EMPTY_STRING, typeOfFood = EMPTY_STRING)
        assertTrue(doordashRestaurant.name == dummyRestaurantName)
    }



}