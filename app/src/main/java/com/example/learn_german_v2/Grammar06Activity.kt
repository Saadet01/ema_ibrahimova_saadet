package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Grammar06Activity : AppCompatActivity() {

    lateinit var textViewExample01: TextView
    lateinit var textViewExample02: TextView
    lateinit var textViewExample03: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammer06)

        textViewExample01=findViewById(R.id.rule_grammer06_examplemodalverbs01)
        textViewExample02=findViewById(R.id.rule_grammer06_examplemodalverbs02)
        textViewExample03=findViewById(R.id.rule_grammer06_examplemodalverbs03)

        textViewExample01.text= getString(R.string.satzGrammer06_01_ger)+"="+getString(R.string.satzGrammer06_01_az)
        textViewExample02.text= getString(R.string.satzGrammer06_02_ger)+"="+getString(R.string.satzGrammer06_02_az)
        textViewExample03.text= getString(R.string.satzGrammer06_03_ger)+"="+getString(R.string.satzGrammer06_03_az)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.selectedItemId=R.id.ic_grammar

        navView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.ic_vocabulary ->
                    startActivity(Intent(this, VocabularyTopicActivity::class.java))
                R.id.ic_dashboard->
                    startActivity(Intent(this, OverviewActivity::class.java))
                R.id.ic_grammar->
                    startActivity(Intent(this, GrammarTopicActivity::class.java))
                R.id.ic_sentences->
                    startActivity(Intent(this, SentencesActivity::class.java))
                R.id.ic_training->
                    startActivity(Intent(this, TrainingTopicActivity::class.java))
            }
            true

        }


    }
}