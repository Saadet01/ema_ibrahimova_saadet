package com.example.learn_german_v2

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class OverviewActivity : AppCompatActivity() {
    lateinit var imageAnimation: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val imageView: ImageView
        imageView=findViewById(R.id.imageView5)
        imageView.setBackgroundResource(R.drawable.animation_button_levels)
        imageAnimation=imageView.background as AnimationDrawable

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        imageAnimation.start()
    }
    fun openLevels(view: View){
        val intent= Intent(this, TrainingTopicActivity::class.java)
        startActivity(intent)
        //  view.setImageResource(R.drawable.drawabletest)
    }

    fun openVocabulary(view: View){
        val intent= Intent(this, VocabularyTopicActivity::class.java)
        startActivity(intent)
        //  view.setImageResource(R.drawable.drawabletest)

    }
    fun openGrammerTopics(view: View){
        val intent=Intent(this,GrammarTopicActivity::class.java)
        startActivity(intent)
    }

    fun openSentences(view: View) {
        val intent=Intent(this, SentencesActivity::class.java)
        startActivity(intent)
    }


}