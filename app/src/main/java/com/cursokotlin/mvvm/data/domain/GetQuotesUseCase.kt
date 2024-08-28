package com.cursokotlin.mvvm.data.domain

import com.cursokotlin.mvvm.data.QuoteRepository
import com.cursokotlin.mvvm.data.model.QuoteModel

class GetQuotesUseCase {

    val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> {
        return repository.getAllQuotes()
    }
}