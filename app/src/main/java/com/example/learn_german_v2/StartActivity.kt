package com.example.learn_german_v2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        val updateHandler = Handler()
        val runnable = Runnable {
            val intent= Intent(this, OverviewActivity::class.java)
            try{
                startActivity(intent)
                finish()
            }catch(ex:Exception){}

        }
        updateHandler.postDelayed(runnable, 3000)

    }



}