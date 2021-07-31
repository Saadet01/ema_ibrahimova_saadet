package com.example.learn_german_v2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class VocabularyTopicAdapter (private val context: Context,
                              private val dataSource: Array<String>): BaseAdapter() {
    var topic_images = arrayOf(R.drawable.topic_family, R.drawable.topic_beruf, R.drawable.topic_gegenstaende,
            R.drawable.topic_ort, R.drawable.topic_fahrzeuge, R.drawable.topic_lebewesen,
            R.drawable.topic_mobel, R.drawable.topic_zeit, R.drawable.topic_obst, R.drawable.topic_gemuse,
            R.drawable.topic_natur, R.drawable.topic_kleidung, R.drawable.topic_korper,
            R.drawable.topic_accessories, R.drawable.topic_sports, R.drawable.topic_farbe)

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.topic_listview, parent, false)

        val topic_image=rowView.findViewById<ImageView>(R.id.topic_image)
        topic_image.setImageResource(topic_images[position])
        val topic_text = rowView.findViewById(R.id.topic_text) as TextView
        topic_text.setText(dataSource[position])

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
         return position.toLong()
    }


    override fun getCount(): Int {
        return dataSource.size
    }
}