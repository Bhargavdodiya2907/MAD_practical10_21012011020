package com.example.mad_practical10_21012011020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.floatingactionbtn)
        fab.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val data = HttpRequest().makeServiceCall(
                        "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                        "dchj8v1b6qqdjzbqood1jgpachyfzlw58r540gru")
                    withContext(Dispatchers.Main) {
                        try {
                            if(data != null)
                                runOnUiThread{getPersonDetailsFromJson(data)}
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Person>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            val Personlistviewe=findViewById<ListView>(R.id.listview)
            Personlistviewe.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }

    fun setarraytolistview(){
        val personListView=findViewById<ListView>(R.id.listview)
        val Array = arrayListOf<Person>(
            Person("bhargav29","bhargav","bhargav@gmail.com","9327857942","veraval",90.90,909.90),
            Person("chintan13","chintan","chintan@gmail.com","7956481235","goladhar",91.90,901.90),
            Person("sagar11","sagar","sagar@gmail.com","1245653897","junagadh",92.90,902.90),
            Person("dev10","dev","dev@gmail.com","7895463218","rajkot",93.90,903.90),
            Person("diya12","diya","diya@gmail.com","1254639875","mehsana",94.90,904.90)
        )

    }
}