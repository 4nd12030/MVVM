package com.cursokotlin.mvvm.domain

import com.cursokotlin.mvvm.data.QuoteRepository
import com.cursokotlin.mvvm.data.database.entities.toDatabase
import com.cursokotlin.mvvm.data.model.Quote
import com.cursokotlin.mvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): List<Quote> {

        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            //Si la llamada al reposiorio falla cargue los datos de la base de datos
            repository.getAllQuotesFromDatabase()
        }
    }


    //val repository = QuoteRepository()
    //Este caso de uso se utiliza para traer todas las citas de la api
//    suspend operator fun invoke(): List<QuoteModel> {
//        return repository.getAllQuotes()
//    }
}