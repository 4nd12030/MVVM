package com.cursokotlin.mvvm.data

import com.cursokotlin.mvvm.data.database.dao.QuoteDao
import com.cursokotlin.mvvm.data.database.entities.QuoteEntity
import com.cursokotlin.mvvm.data.model.Quote
import com.cursokotlin.mvvm.data.model.QuoteModel
import com.cursokotlin.mvvm.data.model.QuoteProvider
import com.cursokotlin.mvvm.data.model.toDomain
import com.cursokotlin.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    //private val quoteProvider: QuoteProvider,
    private val quoteDao: QuoteDao
) {
    //private val api = QuoteService()
//    suspend fun getAllQuotes(): List<QuoteModel>{
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
        //QuoteProvider.quotes = response
        //quoteProvider.quotes = response
        //return response
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDao.inseertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

}