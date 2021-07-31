package com.example.learn_german_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView

//Freepic Icons
class VocabularyTopicActivity : AppCompatActivity() {


    lateinit var  listView: ListView
   // var myArray=arrayOf("a", "b")

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_vocabulary_topic)

       listView=findViewById(R.id.list_topic)
       val topicArray =resources.getStringArray(R.array.topics_array)
       val adapter=VocabularyTopicAdapter(this, topicArray)
       listView.adapter=adapter


       listView.setOnItemClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

           lateinit var topicName: String
           lateinit var germanArray: Array<String>
           lateinit var azeArray: Array<String>
           val bundle = Bundle()
           val intent = Intent(this, VocabularyActivity::class.java)

               if (position == 0) {
                   //To pass whole model data with intent:
                   topicName=topicArray[0]
                   germanArray = resources.getStringArray(R.array.family_german_array_nomen)
                   azeArray=resources.getStringArray(R.array.family_aze_array_nomen)

               }else if (position == 1) {
                   //To pass whole model data with intent:
                   topicName=topicArray[1]
                   germanArray = resources.getStringArray(R.array.job_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.job_aze_array_nomen)
               } else if (position == 2) {
                   topicName=topicArray[2]
                   //To pass whole model data with intent:
                   germanArray = resources.getStringArray(R.array.item_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.item_aze_array_nomen)
               } else if (position == 3) {
                   //To pass whole model data with intent:
                   topicName=topicArray[3]
                   germanArray = resources.getStringArray(R.array.place_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.place_aze_array_nomen)
               } else if (position == 4) {
                   //To pass whole model data with intent:
                   topicName=topicArray[4]
                   germanArray = resources.getStringArray(R.array.transport_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.transport_aze_array_nomen)
               } else if (position == 5) {
                   //To pass whole model data with intent:
                   topicName=topicArray[5]
                   germanArray = resources.getStringArray(R.array.animal_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.animal_aze_array_nomen)
               } else if (position == 6) {
                   //To pass whole model data with intent:
                   topicName=topicArray[6]
                   germanArray = resources.getStringArray(R.array.furniture_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.furniture_aze_array_nomen)
               } else if (position == 7) {
                   //To pass whole model data with intent:
                   topicName=topicArray[7]
                   germanArray = resources.getStringArray(R.array.time_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.time_aze_array_nomen)
               } else if (position == 8) {
                   //To pass whole model data with intent:
                   topicName=topicArray[8]
                   germanArray = resources.getStringArray(R.array.fruit_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.fruit_aze_array_nomen)
               } else if (position == 9) {
                   //To pass whole model data with intent:
                   topicName=topicArray[9]
                   germanArray = resources.getStringArray(R.array.vegetable_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.vegetable_aze_array_nomen)
               } else if (position == 10) {
                   //To pass whole model data with intent:
                   topicName=topicArray[10]
                   germanArray = resources.getStringArray(R.array.natur_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.natur_aze_array_nomen)
               } else if (position == 11) {
                   //To pass whole model data with intent:
                   topicName=topicArray[11]
                   germanArray = resources.getStringArray(R.array.clothes_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.clothes_aze_array_nomen)
               } else if (position == 12) {
                   //To pass whole model data with intent:
                   topicName=topicArray[12]
                   germanArray = resources.getStringArray(R.array.body_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.body_aze_array_nomen)
               } else if (position == 13) {
                   //To pass whole model data with intent:
                   topicName=topicArray[13]
                   germanArray = resources.getStringArray(R.array.accessoire_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.accessoire_aze_array_nomen)
               } else if (position == 14) {
                   //To pass whole model data with intent:
                   topicName=topicArray[14]
                   germanArray = resources.getStringArray(R.array.sport_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.sport_aze_array_nomen)
               } else if (position == 15) {
                   //To pass whole model data with intent:
                   topicName=topicArray[15]
                   germanArray = resources.getStringArray(R.array.color_german_array_nomen)
                   azeArray = resources.getStringArray(R.array.color_aze_array_nomen)
               }
                bundle.putString("TopicName",topicName)
                bundle.putStringArray("GermanArray", germanArray)
                bundle.putStringArray("AzeArray", azeArray)
               intent.putExtras(bundle)
               try {
                   startActivity(intent)
               } catch (ex: Exception) {
               }

       }
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.selectedItemId=R.id.ic_vocabulary

        navView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.ic_vocabulary ->
                    true
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
