package com.example.prakt17

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var pass: EditText
    lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login = findViewById<EditText>(R.id.login)
        pass = findViewById<EditText>(R.id.pass)
    }

    fun handler(v: View) {
        if (v.id == R.id.save) {
            pref = getPreferences(MODE_PRIVATE)
            val ed = pref.edit()
            ed.putString("login", login!!.text.toString())
            ed.putString("password", pass!!.text.toString())
            ed.apply()
        }
        if (v.id == R.id.load) {
            pref = getPreferences(MODE_PRIVATE)
            login!!.setText(pref.getString("login", ""))
            pass!!.setText(pref.getString("password", ""))
        }
    }
}