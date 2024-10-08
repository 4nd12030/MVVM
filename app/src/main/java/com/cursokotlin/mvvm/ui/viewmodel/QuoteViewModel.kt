package com.cursokotlin.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.cursokotlin.mvvm.data.model.Quote
import com.cursokotlin.mvvm.domain.GetQuotesUseCase
import com.cursokotlin.mvvm.domain.GetRandomQuoteUseCase
import com.cursokotlin.mvvm.data.model.QuoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel @Inject constructor(
    //Clases a inyectar
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase

) : ViewModel() {
    //LiveData es un tipo de dato al cual el activity se puede conectar para saber cuadno hay un cambio en el modelo
//    val quoteModel = MutableLiveData<QuoteModel?>()
    val quoteModel = MutableLiveData<Quote?>()
    val isLoading = MutableLiveData<Boolean>()

//    var getQuoseUseCase = GetQuotesUseCase()
//    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    //Este metodo sera al que acceda nuestra vista
    fun randomQuote() {
        //Llama al provider para que devuelva una nueva cita
        //val currentQuote = QuoteProvider.random()
        //La nueva cita se añade a la variable livedata con postValue() para que la vista reconozca el cambio y lo pinte
        //quoteModel.postValue(currentQuote)
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }


    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            //Asigna la primera cita a la pantalla cuando el usuario inicia la aplicacion
            if (result.isNotEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }
    }

}