package com.danigelabert.examendani.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students")
data class Alumnes(

    @ColumnInfo(name = "name")
    var nom: String,
    @ColumnInfo(name = "group")
    var grup: String,
    @ColumnInfo(name = "note")
    var nota: Int
) {
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}
