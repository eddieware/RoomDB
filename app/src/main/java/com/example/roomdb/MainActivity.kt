package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // println("->!!!!!!!!!!!!!!!!!!!!!EDUARDO!!!!!!!!!!!!!!!!!!!!!!!!")



        var db= Room.databaseBuilder(applicationContext, AppDB::class.java,"EmployeeDB").build()

        Thread{
            var emp = Emp_Entity()
            emp.emp_id = 2
            emp.emp_name ="NILESH"
            emp.emp_post= "RH"
          /*
            emp.emp_id = 3
            emp.emp_name="Eduardo mejia3"
            emp.emp_post="Application Developer3"
            db.empDAO().saveEmp(emp)*/
            //db.empDAO().delData(emp)
            db.empDAO().update(emp)

            db.empDAO().readEmp().forEach{
                Log.i("@EDUARDO", " ID is ${it.emp_id}")
                Log.i("@EDUARDO", " Name is ${it.emp_name}")
                Log.i("@EDUARDO", " Position is ${it.emp_post}")



            }


        }.start()


    }
}
