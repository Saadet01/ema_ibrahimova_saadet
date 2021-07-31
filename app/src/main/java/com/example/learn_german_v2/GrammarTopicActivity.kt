package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView

class GrammarTopicActivity : AppCompatActivity() {
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammer_topic)

        listView=findViewById(R.id.list_grammer)
        val grammarTopicArray=resources.getStringArray(R.array.grammer_overview_aze)
        val adapter=GrammarTopicAdapter(this, grammarTopicArray)
        listView.adapter=adapter

        listView.setOnItemClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            lateinit var intent: Intent

            if (position == 0) {
                //To pass whole model data with intent:
                intent = Intent(this, Grammar01Activity::class.java)
            } else if (position == 1) {
                //To pass whole model data with intent:
                intent = Intent(this, Grammar02Activity::class.java)
            }else if (position==2){
                intent=Intent(this, Grammar03Activity::class.java)
            }else if(position==3){
                intent=Intent(this,Grammar04Activity::class.java)
            }else if(position==4){
                intent=Intent(this,Grammar05Activity::class.java)
            }else if(position==5){
                intent=Intent(this,Grammar06Activity::class.java)
            }else if(position==6){
                intent=Intent(this,Grammar07Activity::class.java)
            }else if(position==7){
                intent=Intent(this, Grammar08Activity::class.java)
            }else if(position==8){
                intent=Intent(this, Grammar09Activity::class.java)
            }else if(position==9){
                intent=Intent(this, Grammar10Activity::class.java)
            }else if(position==10){
                intent=Intent(this, Grammar11Activity::class.java)
            }else if(position==11){
                intent=Intent(this, Grammar12Activity::class.java)
            }else if(position==12){
                intent=Intent(this, Grammar13Activity::class.java)
            }
            try {
                startActivity(intent)
            } catch (ex: Exception) {}

        }
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.selectedItemId=R.id.ic_grammar

        navView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.ic_vocabulary ->
                    startActivity(Intent(this, VocabularyTopicActivity::class.java))
                R.id.ic_dashboard->
                    startActivity(Intent(this, OverviewActivity::class.java))
                R.id.ic_grammar->
                    true
                R.id.ic_sentences->
                    startActivity(Intent(this, SentencesActivity::class.java))
                R.id.ic_training->
                    startActivity(Intent(this, TrainingTopicActivity::class.java))
            }
            true

        }
    }
}