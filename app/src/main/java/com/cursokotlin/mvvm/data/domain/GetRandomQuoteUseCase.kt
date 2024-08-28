package com.cursokotlin.mvvm.data.domain

import com.cursokotlin.mvvm.data.model.QuoteModel
import com.cursokotlin.mvvm.data.model.QuoteProvider

//Este caso de uso devuelve una cita aleatoria de la lista de citas que se obtiene de internet mediante retrofit

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        //val randomNumber = (0..<quotes.size-1).random()
        val randomNumber = (quotes.indices).random()

        if (quotes.isNotEmpty()) {
            return quotes[randomNumber]
        }

        return null
    }


}