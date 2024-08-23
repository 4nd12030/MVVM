package com.cursokotlin.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursokotlin.mvvm.model.QuoteModel
import com.cursokotlin.mvvm.model.QuoteProvider

class QuoteViewModel: ViewModel() {
    //LiveData es un tipo de dato al cual el activity se puede conectar para saber cuadno hay un cambio en el modelo
    val quoteModel = MutableLiveData<QuoteModel>()

    //Este metodo sera al que acceda nuestra vista
    fun randomQuote(){
        //Llama al provider para que devuelva una nueva cita
        val currentQuote = QuoteProvider.random()
        //La nueva cita se añade a la variable livedata con postValue() para que la vista reconozca el cambio y lo pinte
        quoteModel.postValue(currentQuote)
    }

}