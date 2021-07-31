package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class Grammar01Activity : AppCompatActivity() {
    lateinit var textViewHeading: TextView
    lateinit var textViewIntroduction: TextView
    lateinit var imageViewAlphabetSound: ImageView
    lateinit var imageViewAlphabet: ImageView
    lateinit var mTTs: TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammer01)


        imageViewAlphabetSound=findViewById(R.id.rule_grammer_alphabet_sound)

        mTTs= TextToSpeech(this, TextToSpeech.OnInitListener { status->
            if(status!= TextToSpeech.ERROR){
                mTTs.language= Locale.GERMAN
                mTTs.setSpeechRate(1.0F)
            }
        })
        imageViewAlphabetSound.setOnClickListener {
            if(mTTs.isSpeaking==true) {
                mTTs.stop()
            }else {
                mTTs.speak("a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, ä, ö, ü, s",
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