package com.example.learn_german_v2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2


class LevelActivity : AppCompatActivity() {

    lateinit var levelImageTop: ImageView
    lateinit var levelTitel: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        levelImageTop=findViewById(R.id.level_topimage)
        levelTitel=findViewById(R.id.level_titel)

        val bundle=intent.extras
        val levelaze=bundle!!.getStringArray("LevelAzeArray")
        val levelger = bundle.getStringArray("LevelGermanArray")
        levelTitel.setText(bundle.getString("TitelLevel"))

        val pagerAdapter = LevelPagerAdapter( levelaze!!, levelger!!)
        val viewPager : ViewPager2=findViewById(R.id.level_viewpager)
        viewPager.adapter=pagerAdapter









    }

}