package com.example.roomdb

import androidx.room.*


@Database(entities = [(Emp_Entity::class)],version = 1) //llamamos la tabla
abstract class AppDB : RoomDatabase(){
    abstract fun empDAO(): Emp_DAO //definimos la funcion emp DAO y la referenciamos al emp dao para hacer un insert




}