package com.danigelabert.examendani.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.danigelabert.examendani.databases.AlumnesDatabase
import com.danigelabert.examendani.model.Alumnes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {

    companion object {

        var alumnesDatabase: AlumnesDatabase? = null

        var alumne: LiveData<List<Alumnes>>? = null


        fun initializeDB(context: Context): AlumnesDatabase {
            return AlumnesDatabase.getDatabase(context)
        }

        //INSERT alumne
        fun insertAlumne(context: Context, alumnes: Alumnes) {

            alumnesDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                alumnesDatabase!!.alumnesDao().addAlumnes(alumnes)
            }
        }

        //SELECT * alumnes
        fun getAlumnes(context: Context): LiveData<List<Alumnes>>? {

            alumnesDatabase = initializeDB(context)

            alumne = alumnesDatabase!!.alumnesDao().getAlumnes()

            return alumne
        }

        //SELECT aprovats
        fun getAlumnesAprovats(context: Context): LiveData<List<Alumnes>>? {

            alumnesDatabase = initializeDB(context)

            return alumnesDatabase!!.alumnesDao().getAlumneAprovats()
        }

        //SELECT suspesos
        fun getAlumnesSuspesos(context: Context): LiveData<List<Alumnes>>? {

            alumnesDatabase = initializeDB(context)

            return alumnesDatabase!!.alumnesDao().getAlumneNoAprovats()
        }
    }
}