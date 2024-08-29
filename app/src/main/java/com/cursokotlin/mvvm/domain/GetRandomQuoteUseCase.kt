package com.cursokotlin.mvvm.domain

import com.cursokotlin.mvvm.data.model.QuoteModel
import com.cursokotlin.mvvm.data.model.QuoteProvider
import javax.inject.Inject

//Este caso de uso devuelve una cita aleatoria de la lista de citas que se obtiene de internet mediante retrofit

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {

    operator fun invoke(): QuoteModel?{
        //val quotes = QuoteProvider.quotes
        val quotes = quoteProvider.quotes
        //val randomNumber = (0..<quotes.size-1).random()
        val randomNumber = (quotes.indices).random()

        if (quotes.isNotEmpty()) {
            return quotes[randomNumber]
        }

        return null
    }


}