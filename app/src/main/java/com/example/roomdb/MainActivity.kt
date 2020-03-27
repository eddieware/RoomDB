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
            emp.emp_id = 1
            emp.emp_name="Eduardo mejia"
            emp.emp_post="Q&A"
            db.empDAO().saveEmp(emp)

            db.empDAO().readEmp().forEach{
                Log.i("@EDUARDO", "HELLO!!!!!")



            }


        }.start()


    }
}
