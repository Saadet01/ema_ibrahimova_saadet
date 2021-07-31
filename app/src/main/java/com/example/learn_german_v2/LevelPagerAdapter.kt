package com.example.learn_german_v2


import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import java.util.*

// 1
class LevelPagerAdapter(val levelaze: Array<String>, val levelger: Array<String>) :
        RecyclerView.Adapter<LevelPagerAdapter.LevelPagerViewHolder>() {


    inner class LevelPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return levelger.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelPagerViewHolder {
        lateinit var mTTs: TextToSpeech
        lateinit var questionButton: ImageView

        val view=LayoutInflater.from(parent.context).inflate(R.layout.level_fragment,parent,false)

        val germanTextView = view.findViewById(R.id.level_textview_german) as TextView
        questionButton=view.findViewById(R.id.questionButton)

        val soundTextButton=view.findViewById<ImageView>(R.id.soundLevel)

        mTTs = TextToSpeech(parent.context, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR) {
                mTTs.language = Locale.GERMAN
                mTTs.setSpeechRate(1.0F)
            }
        })
        soundTextButton.setOnClickListener {
            val germanWord = germanTextView.text.toString()
            mTTs.speak(germanWord, TextToSpeech.QUEUE_FLUSH, null)
        }
        questionButton.setOnClickListener(){
            questionButton.setImageResource(R.drawable.lightbulb)
            view.findViewById<TextView>(R.id.level_textview_german).visibility=View.VISIBLE
            val germanWord = germanTextView.text.toString()
            mTTs.speak(germanWord, TextToSpeech.QUEUE_FLUSH, null)
        }

        return LevelPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelPagerViewHolder, position: Int) {
        val levelGermanWord=levelger[position]
        val levelAzeWord=levelaze[position]

        holder.itemView.findViewById<TextView>(R.id.level_textview_german).text = levelGermanWord
        holder.itemView.findViewById<TextView>(R.id.level_textview_aze).text=levelAzeWord

    }
}