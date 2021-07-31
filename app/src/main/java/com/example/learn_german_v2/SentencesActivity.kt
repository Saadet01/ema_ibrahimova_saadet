package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SentencesActivity : AppCompatActivity() {
    lateinit var  listView: ListView
    lateinit var topicSentences: TextView
    lateinit var germanSentences: Array<String>
    lateinit var azeSentences: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentences)

        listView=findViewById(R.id.list_sentences)
        topicSentences=findViewById(R.id.topic_sentences)

        germanSentences= arrayOf(getString(R.string.satz01_ger), getString(R.string.satz02_ger), getString(R.string.satz03_ger), getString(R.string.satz04_ger),
        getString(R.string.satz05_ger), getString(R.string.satz06_ger), getString(R.string.satz07_ger), getString(R.string.satz08_ger), getString(R.string.satz09_ger), getString(R.string.satz10_ger),
        getString(R.string.satz11_ger), getString(R.string.satz12_ger),getString(R.string.satz13_ger), getString(R.string.satz14_ger),
                getString(R.string.satz15_ger), getString(R.string.satz16_ger), getString(R.string.satz17_ger),
                getString(R.string.satz18_ger), getString(R.string.satz19_ger), getString(R.string.satz20_ger),
                getString(R.string.satz21_ger), getString(R.string.satz22_ger), getString(R.string.satz23_ger), getString(R.string.satz24_ger),
                getString(R.string.satz25_ger), getString(R.string.satz26_ger), getString(R.string.satz27_ger))

        azeSentences= arrayOf(getString(R.string.satz01_az), getString(R.string.satz02_az), getString(R.string.satz03_az), getString(R.string.satz04_az),
                getString(R.string.satz05_az), getString(R.string.satz06_az), getString(R.string.satz07_az), getString(R.string.satz08_az), getString(R.string.satz09_az), getString(R.string.satz10_az),
                getString(R.string.satz11_az), getString(R.string.satz12_az), getString(R.string.satz13_az), getString(R.string.satz14_az),
                getString(R.string.satz15_az), getString(R.string.satz16_az), getString(R.string.satz17_az),
                getString(R.string.satz18_az), getString(R.string.satz19_az), getString(R.string.satz20_az),
                getString(R.string.satz21_az), getString(R.string.satz22_az), getString(R.string.satz23_az), getString(R.string.satz24_az),
                getString(R.string.satz25_az), getString(R.string.satz26_az), getString(R.string.satz27_az))

        val adapter=SentencesAdapter(this, germanSentences, azeSentences)

        listView.adapter=adapter

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.selectedItemId=R.id.ic_sentences

        navView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.ic_vocabulary ->
                    startActivity(Intent(this, VocabularyTopicActivity::class.java))
                R.id.ic_dashboard->
                    startActivity(Intent(this, OverviewActivity::class.java))
                R.id.ic_grammar->
                    startActivity(Intent(this, GrammarTopicActivity::class.java))
                R.id.ic_sentences->
                    true
                R.id.ic_training->
                    startActivity(Intent(this, TrainingTopicActivity::class.java))
            }
            true

        }


    }
}