package com.example.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnNextScreen: Button
    lateinit var edittextName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnNextScreen = findViewById(R.id.btn1)
        btnNextScreen.setOnClickListener {
            edittextName = findViewById(R.id.et_name)
            if (edittextName.text.isNullOrEmpty()) {
                Toast.makeText(this, "OOPS you forgot to enter your name", Toast.LENGTH_SHORT)
                    .show()

            } else {
                var name = edittextName.text.toString()
                val intent = Intent(this, SecActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        }
    }
}
