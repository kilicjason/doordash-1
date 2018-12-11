package com.doordash.anroid.di


import com.doordash.anroid.repository.api.DoordashApi
import com.doordash.anroid.util.BASE_URL
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    @ApplicationScope
    fun provideDoordashApi(): DoordashApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(DoordashApi::class.java)
    }

}