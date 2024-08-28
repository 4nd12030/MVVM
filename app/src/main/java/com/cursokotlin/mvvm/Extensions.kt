package com.cursokotlin.mvvm

import android.app.Activity
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

class Extensions {

    companion object{
        fun String.happy(): String{
            return "$this :)"
        }

        fun Any?.isNull() = this == null

        fun Activity.toast(text: String, duration: Int = Toast.LENGTH_SHORT){
            Toast.makeText(this,text, duration).show()
        }

        fun Activity.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)

    }

}