package com.example.learn_german_v2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*


class SentencesAdapter (private val context: Context,
                       private val germanSentenceArray: Array<String>, private val azeSentenceArray: Array<String>): BaseAdapter() {


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.sentences_listview, parent, false)
        val sentenceGerman = rowView.findViewById(R.id.sentence_german) as TextView
        sentenceGerman.setText(germanSentenceArray[position])
        val sentenceAze = rowView.findViewById<TextView>(R.id.sentence_aze)
        sentenceAze.setText(azeSentenceArray[position])

        lateinit var imageView: ImageView
        lateinit var mTTs: TextToSpeech

        mTTs = TextToSpeech(context, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR) {
                mTTs.language = Locale.GERMAN
                mTTs.setSpeechRate(1.0F)
            }
        })

        imageView = rowView.findViewById(R.id.soundSentences)
        imageView.setOnClickListener {
            val germanTextView = rowView.findViewById(R.id.sentence_german) as TextView
            val germanWord = germanTextView.text.toString()

            mTTs.speak(germanWord, TextToSpeech.QUEUE_FLUSH, null)
        }

        return rowView
    }

    override fun getItem(position: Int): Any {
        return germanSentenceArray[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return germanSentenceArray.size
    }
}
