package com.example.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecActivity : AppCompatActivity() {
    var TAG = "NikilsDebug"
    lateinit var randomNum: TextView
    lateinit var buttonImplicitIntent: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sec_activiry)
        randomNum = findViewById(R.id.randomNum)
        buttonImplicitIntent = findViewById(R.id.bt_impintent)

        //storing data from the methods
        var randomNumber = getRandomNumber(4)
        Log.d(TAG, "onCreate: " + randomNumber)
        var name = getName()

        //setting Random Number to TextView
        randomNum.text = randomNumber

        //Implicit Intent
        buttonImplicitIntent.setOnClickListener {
            shareResults(name, randomNumber)
        }

    }

    fun getRandomNumber(count: Int): String {
        var number = List(count) {
            (0..43).random()
        }
        return number.joinToString(separator = " ")
    }

    fun getName(): String {
        var bundle: Bundle? = intent.extras
        var name = bundle?.getString("name").toString()
        return name
    }

    fun shareResults(name: String, randomNumber: String) {
        var intentImplicit = Intent(Intent.ACTION_SEND)
        intentImplicit.setType("plain/text")
        intentImplicit.putExtra(Intent.EXTRA_SUBJECT, "Username is $name")
        intentImplicit.putExtra(Intent.EXTRA_TEXT, "Lottery Number is $randomNumber")
        startActivity(intentImplicit)
    }
}