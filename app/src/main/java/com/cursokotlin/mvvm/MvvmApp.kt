package com.cursokotlin.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Clase que extiende de la propia aplicacion y que  va a ser la primera en llamarse cuando empiece la app
@HiltAndroidApp
class MvvmApp: Application()