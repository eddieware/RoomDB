package com.example.roomdb

import androidx.room.*

@Dao
interface Emp_DAO {
    @Insert
    fun saveEmp(emp: Emp_Entity)

    @Query("select * from Emp_Entity")
    fun readEmp(): List<Emp_Entity>

    @Delete
   fun delData(emp: Emp_Entity)

    @Update
    fun update(emp: Emp_Entity)
}