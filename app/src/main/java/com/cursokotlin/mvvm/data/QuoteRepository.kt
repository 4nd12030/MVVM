package com.cursokotlin.mvvm.data

import com.cursokotlin.mvvm.data.model.QuoteModel
import com.cursokotlin.mvvm.data.model.QuoteProvider
import com.cursokotlin.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
){
   //private val api = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        //QuoteProvider.quotes = response
        quoteProvider.quotes = response
        return response
    }

}