package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class VocabularyActivity : AppCompatActivity() {
    lateinit var  listView: ListView
    lateinit var topicVocabulary: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)

        listView=findViewById(R.id.list_vocabulary)
        //hier array_nomen und array_verben zusammen zu einem Array

        val bundle=intent.extras
        val topic=bundle!!.getString("TopicName")
        val vocabularyGermanArray = bundle!!.getStringArray("GermanArray")
        val vocabularyAzeArray=bundle!!.getStringArray("AzeArray")
        val adapter=VocabularyAdapter(this, vocabularyGermanArray!!, vocabularyAzeArray!!)
        topicVocabulary=findViewById(R.id.topic_vokabeln)
        topicVocabulary.setText(topic)
        listView.adapter=adapter

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.selectedItemId=R.id.ic_vocabulary

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