package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll: Button = findViewById(R.id.btn_roll)
        btnRoll.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
    }
}