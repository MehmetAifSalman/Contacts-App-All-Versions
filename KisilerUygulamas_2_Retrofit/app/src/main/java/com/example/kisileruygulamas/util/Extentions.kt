package com.example.kisileruygulamas.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecisyap(it : View , id : Int){
    findNavController(it).navigate(id)
}
fun Navigation.gecisyap(it : View , id : NavDirections){
    findNavController(it).navigate(id)
}