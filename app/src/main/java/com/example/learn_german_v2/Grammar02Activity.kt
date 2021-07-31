package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class Grammar02Activity : AppCompatActivity() {

    lateinit var imageViewNumberSound: ImageView
    lateinit var mTTs: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammer02)


        imageViewNumberSound=findViewById(R.id.rule_grammer02_number_sound)


        mTTs= TextToSpeech(this, TextToSpeech.OnInitListener { status->
            if(status!= TextToSpeech.ERROR){
                mTTs.language= Locale.GERMAN
                mTTs.setSpeechRate(1.0F)
            }
        })
        imageViewNumberSound.setOnClickListener {
            if(mTTs.isSpeaking==true){
                mTTs.stop()
            }else {
                mTTs.speak("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000",
                        TextToSpeech.QUEUE_FLUSH, null)
            }
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
                    startActivity(Intent(this, GrammarTopicActivity::class.java))
                R.id.ic_sentences->
                    startActivity(Intent(this, SentencesActivity::class.java))
                R.id.ic_training->
                    startActivity(Intent(this, TrainingTopicActivity::class.java))
            }
            true

        }

    }
    override fun onPause() {
        super.onPause()
        mTTs.stop()
    }
}