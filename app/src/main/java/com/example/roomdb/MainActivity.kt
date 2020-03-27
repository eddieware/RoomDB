package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db= Room.databaseBuilder(applicationContext, AppDB::class.java,"EmployeeDB").build()

        Thread{
            var emp = Emp_Entity()
            emp.emp_id = 1
            emp.emp_name="Eddie"
            emp.emp_post="Q&A"
            db.empDAO().saveEmp(emp)

        }.start()


    }
}
