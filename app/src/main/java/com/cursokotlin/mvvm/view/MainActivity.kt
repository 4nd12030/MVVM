package com.cursokotlin.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.cursokotlin.mvvm.databinding.ActivityMainBinding
import com.cursokotlin.mvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    //View Binding -> Declaracion de variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var tvQuote: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var viewContainer: View

    //View Model
    private val quoteViewModel: QuoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(View Binding) -> Inicializa la variable
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View Binding -> Inicializacion de variables
        viewContainer = binding.viewContainer
        tvQuote = binding.tvQuote
        tvAuthor = binding.tvAuthor


        //View Model -> Suscribe el cambio en la view mediante la funcion observe()
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            tvQuote.text = currentQuote.quote
            tvAuthor.text = currentQuote.author
        })
//        quoteViewModel.quoteModel.observe(this){
//            tvQuote.text = it.quote
//            tvAuthor.text = it.author
//        }

        //La accion se detona cada que se toque la pantalla
        viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }







}