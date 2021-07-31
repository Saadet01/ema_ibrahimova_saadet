package com.example.learn_german_v2

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.DrawableRes
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class TrainingTopicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_topic)
    }


    fun goToLevel(view: View){
        val bundle = Bundle()
        val intent = Intent(this, LevelActivity::class.java)
        lateinit var levelaze : Array<String>
        lateinit var levelger : Array<String>
        lateinit var titelLevel: String

        if(view.id==R.id.Button01) {
            levelaze = resources.getStringArray(R.array.level01_aze)
            levelger = resources.getStringArray(R.array.level01_ger)
            titelLevel="Level01"
        }else if (view.id==R.id.Button02){
            levelaze = resources.getStringArray(R.array.level02_aze)
            levelger = resources.getStringArray(R.array.level02_ger)
            titelLevel="Level02"
        }else if (view.id==R.id.Button03){
            levelaze = resources.getStringArray(R.array.level03_aze)
            levelger = resources.getStringArray(R.array.level03_ger)
            titelLevel="Level03"
        }else if (view.id==R.id.Button04){
            levelaze = resources.getStringArray(R.array.level04_aze)
            levelger = resources.getStringArray(R.array.level04_ger)
            titelLevel="Level04"
        }else if (view.id==R.id.Button05){
            levelaze = resources.getStringArray(R.array.level05_aze)
            levelger = resources.getStringArray(R.array.level05_ger)
            titelLevel="Level05"
        }else if (view.id==R.id.Button06){
            levelaze = resources.getStringArray(R.array.level06_aze)
            levelger = resources.getStringArray(R.array.level06_ger)
            titelLevel="Level06"
        }else if (view.id==R.id.Button07){
            levelaze = resources.getStringArray(R.array.level07_aze)
            levelger = resources.getStringArray(R.array.level07_ger)
            titelLevel="Level07"
        }else if (view.id==R.id.Button08){
            levelaze = resources.getStringArray(R.array.level08_aze)
            levelger = resources.getStringArray(R.array.level08_ger)
            titelLevel="Level08"
        }else if (view.id==R.id.Button09){
            levelaze = resources.getStringArray(R.array.level09_aze)
            levelger = resources.getStringArray(R.array.level09_ger)
            titelLevel="Level09"
        }else if (view.id==R.id.Button10){
            levelaze = resources.getStringArray(R.array.level10_aze)
            levelger = resources.getStringArray(R.array.level10_ger)
            titelLevel="Level10"
        }
        bundle.putString("TitelLevel", titelLevel)
        bundle.putStringArray("LevelAzeArray", levelaze)
        bundle.putStringArray("LevelGermanArray", levelger)
        intent.putExtras(bundle)
        startActivity(intent)
      //  view.setImageResource(R.drawable.drawabletest)

    }

}