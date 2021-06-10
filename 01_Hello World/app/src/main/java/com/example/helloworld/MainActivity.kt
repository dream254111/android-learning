package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var btnRoll: Button
    lateinit var btnCountUp: Button
    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRoll = findViewById(R.id.btn_roll)
        btnCountUp = findViewById(R.id.btn_count_up)
        txtResult = findViewById(R.id.txt_result)

        btnRoll.setOnClickListener { rollDice() }
        btnCountUp.setOnClickListener { upTextValue() }
    }

    private fun rollDice() {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()
        txtResult.text = randomInt.toString()
    }

    private fun upTextValue() {
        try {
            val value: Int = Integer.parseInt(txtResult.text.toString())
            txtResult.text = if (value != 6) (value + 1).toString() else "6"
        } catch (ex: Exception) {
            txtResult.text = "1"
        }
    }
}