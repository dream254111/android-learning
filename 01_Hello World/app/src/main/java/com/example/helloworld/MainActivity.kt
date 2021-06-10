package com.example.helloworld

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var btnRoll: Button
    lateinit var btnCountUp: Button
    lateinit var imgDice: ImageView
    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRoll = findViewById(R.id.btn_roll)
        btnCountUp = findViewById(R.id.btn_count_up)
        imgDice = findViewById(R.id.img_dice)
        txtResult = findViewById(R.id.txt_result)

        btnRoll.setOnClickListener { rollDice() }
        btnCountUp.setOnClickListener { upTextValue() }
    }

    private fun rollDice() {
        imgDice.visibility = View.VISIBLE
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()
        txtResult.text = randomInt.toString()
        imgDice.setImageResource(when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        })
    }

    private fun upTextValue() {
        imgDice.visibility = View.VISIBLE
        try {
            val value: Int = Integer.parseInt(txtResult.text.toString())
            txtResult.text = if (value != 6) (value + 1).toString() else "6"
            imgDice.setImageResource(when (value + 1) {
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6, 7 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            })
        } catch (ex: Exception) {
            txtResult.text = "1"
            imgDice.setImageResource(R.drawable.dice_1)
        }
    }
}