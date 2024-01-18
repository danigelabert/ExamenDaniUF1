package com.danigelabert.examendani.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.danigelabert.examendani.model.Alumnes
import com.danigelabert.examendani.repositori.Repositori

class InsertViewModel: ViewModel() {

    //insert alumnes
    fun newAlumnes(context: Context, nom:String, grup:String, preu:Int) {

        var alumne = Alumnes(nom, grup, preu)
        Repositori.insertAlumne(context,alumne)
    }

}