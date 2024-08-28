package com.cursokotlin.mvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object {

        var URL = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"

        fun getRetrofit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}