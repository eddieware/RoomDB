package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {
    private lateinit var mDb:AppDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // println("->!!!!!!!!!!!!!!!!!!!!!EDUARDO!!!!!!!!!!!!!!!!!!!!!!!!")



        var db= Room.databaseBuilder(applicationContext, AppDB::class.java,"EmployeeDB").build()

        // Make the text view scrollable
        textView.movementMethod = ScrollingMovementMethod()

        btnUpdate.setOnClickListener {
            Thread{

                var emp = Emp_Entity()


                emp.emp_id = 2
                emp.emp_name ="NILESH"
                emp.emp_post= "RRHH4"
                db.empDAO().update(emp)


                /*
                  emp.emp_id = 3
                  emp.emp_name="Eduardo mejia3"
                  emp.emp_post="Application Developer3"
                  db.empDAO().saveEmp(emp)*/
                //db.empDAO().delData(emp)


                db.empDAO().readEmp().forEach{
                    Log.i("@EDUARDO", " ID is ${it.emp_id}")
                    Log.i("@EDUARDO", " Name is ${it.emp_name}")
                    Log.i("@EDUARDO", " Position is ${it.emp_post}")

                }

            }.start()

        }

        btnSelect.setOnClickListener {
            //val list = mDb.studentDao().allStudents()
            doAsync {
                val list = mDb.empDAO().readEmp()

                uiThread {
                    toast("${list.size} records found.")
                    textView.text = ""

                    for (emp in list){
                        //textView.append("${student.id} : ${student.fullName} : ${student.result}\n")
                        textView.append("${emp.emp_id}: ${emp.emp_name}: ${emp.emp_post}\n")
                        println("->!!!!!!!!!!!!!!!!!!!!!EDUARDO!!!!!!!!!!!!!!!!!!!!!!!!")

                    }

                }

            }

        }




    }
}
