package com.cursokotlin.mvvm.domain

import com.cursokotlin.mvvm.data.QuoteRepository
import com.cursokotlin.mvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private  val repository: QuoteRepository
) {
    //val repository = QuoteRepository()

    //Este caso de uso se utiliza para traer todas las citas de la api
    suspend operator fun invoke(): List<QuoteModel> {
        return repository.getAllQuotes()
    }
}