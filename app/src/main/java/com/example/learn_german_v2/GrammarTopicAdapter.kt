package com.example.learn_german_v2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class GrammarTopicAdapter(private val context: Context,
                          private val dataSource: Array<String>): BaseAdapter()  {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val newView = inflater.inflate(R.layout.grammer_listview, parent, false)
        val grammerTopicText=newView.findViewById<TextView>(R.id.grammer_topic)
        grammerTopicText.setText(dataSource[position])
        return newView
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