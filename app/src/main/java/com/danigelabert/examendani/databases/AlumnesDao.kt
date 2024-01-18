package com.danigelabert.examendani.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danigelabert.examendani.model.Alumnes

@Dao
interface AlumnesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAlumnes(alumnes: Alumnes)

    @Query("SELECT * FROM students ORDER BY name DESC")
    fun getAlumnes(): LiveData<List<Alumnes>>

    @Query("SELECT * FROM students  where note >= 5")
    fun getAlumneAprovats(id:Int): LiveData<List<Alumnes>>

    @Query("SELECT * FROM students  where note < 5")
    fun getAlumneNoAprovats(id:Int): LiveData<List<Alumnes>>
}