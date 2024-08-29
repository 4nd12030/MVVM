package com.cursokotlin.mvvm.data.model

import com.cursokotlin.mvvm.data.database.entities.QuoteEntity

data class Quote(
    val quote: String,
    val author: String
)


//Funcion Extension
fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)