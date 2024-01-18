package com.danigelabert.examendani.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.danigelabert.examendani.model.Alumnes
import com.danigelabert.examendani.repositori.Repositori

class grupViewModel: ViewModel() {

    //select * alumnes
    fun obtenirMobles(context: Context) : LiveData<List<Alumnes>>? {
        return Repositori.getAlumnes(context)
    }

    //select aprovats
    fun getAlumnesAprovats(context: Context) : LiveData<List<Alumnes>>? {
        return Repositori.getAlumnesAprovats(context)
    }

    //select suspesos
    fun getAlumnesNoAprovats(context: Context) : LiveData<List<Alumnes>>? {
        return Repositori.getAlumnesSuspesos(context)
    }
}