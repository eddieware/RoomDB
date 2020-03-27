package com.example.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Emp_DAO {
    @Insert
    fun saveEmp(emp: Emp_Entity)

    @Query("select * from Emp_Entity")
    fun readEmp(): List<Emp_Entity>
}