package com.cursokotlin.mvvm.data.network

import com.cursokotlin.mvvm.core.RetrofitHelper
import com.cursokotlin.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class QuoteService @Inject constructor(
    private val api:QuoteApiClient
){
    //private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {

        return withContext(Dispatchers.IO) {
//            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }

    }

}