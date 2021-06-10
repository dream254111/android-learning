package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnRoll: Button
    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRoll = findViewById(R.id.btn_roll)
        txtResult = findViewById(R.id.txt_result)

        btnRoll.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()
        txtResult.text = randomInt.toString()
    }
}