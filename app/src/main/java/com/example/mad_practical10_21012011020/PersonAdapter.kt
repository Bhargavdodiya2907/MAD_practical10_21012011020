package com.example.mad_practical10_21012011020

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class PersonAdapter (context: Context, val PersonArray:ArrayList<Person>):ArrayAdapter<Person>(context,0,PersonArray) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false)
        return view
    }
}