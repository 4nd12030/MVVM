package com.cursokotlin.mvvm.di

import com.cursokotlin.mvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {
        val URL = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerApiClient(retrofit: Retrofit): QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }

}

