package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class Grammar09Activity : AppCompatActivity() {

    lateinit var imageSound01: ImageView
    lateinit var imageSound02: ImageView
    lateinit var imageSound03: ImageView
    lateinit var imageSound04: ImageView
    lateinit var textSentence01Ger: TextView
    lateinit var textSentence02Ger: TextView
    lateinit var textSentence03Ger: TextView
    lateinit var textSentence04Ger: TextView
    lateinit var mTTs: TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar09)

        imageSound01=findViewById(R.id.grammar09_sentence01_sound)
        imageSound02=findViewById(R.id.grammar09_sentence02_sound)
        imageSound03=findViewById(R.id.grammar09_sentence03_sound)
        imageSound04=findViewById(R.id.grammer09_sentence04_sound)
        textSentence01Ger=findViewById(R.id.grammar09_sentence01_ger)
        textSentence02Ger=findViewById(R.id.grammar09_sentence02_ger)
        textSentence03Ger=findViewById(R.id.grammar09_sentence03_ger)
        textSentence04Ger=findViewById(R.id.grammar09_sentence04_ger)

        mTTs= TextToSpeech(this, TextToSpeech.OnInitListener { status->
            if(status!= TextToSpeech.ERROR){
                mTTs.language= Locale.GERMAN
                mTTs.setSpeechRate(1.0F)
            }
        })

        imageSound01.setOnClickListener {
            if(mTTs.isSpeaking==true){
                mTTs.stop()
            }else {
                mTTs.speak(textSentence01Ger.text.toString(),
                        TextToSpeech.QUEUE_FLUSH, null)
            }
        }
        imageSound02.setOnClickListener {
            if(mTTs.isSpeaking==true){
                mTTs.stop()
            }else {
                mTTs.speak(textSentence02Ger.text.toString(),
                        TextToSpeech.QUEUE_FLUSH, null)
            }
        }
        imageSound03.setOnClickListener {
            if(mTTs.isSpeaking==true){
                mTTs.stop()
            }else {
                mTTs.speak(textSentence03Ger.text.toString(),
                        TextToSpeech.QUEUE_FLUSH, null)
            }
        }
        imageSound04.setOnClickListener {
            if(mTTs.isSpeaking==true){
                mTTs.stop()
            }else {
                mTTs.speak(textSentence04Ger.text.toString(),
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
}