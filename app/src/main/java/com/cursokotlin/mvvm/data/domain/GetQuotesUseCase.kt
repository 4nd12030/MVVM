package com.cursokotlin.mvvm.data.domain

import com.cursokotlin.mvvm.data.QuoteRepository
import com.cursokotlin.mvvm.data.model.QuoteModel

class GetQuotesUseCase {

    val repository = QuoteRepository()

    //Este caso de uso se utiliza para traer todas las citas de la api
    suspend operator fun invoke(): List<QuoteModel> {
        return repository.getAllQuotes()
    }
}