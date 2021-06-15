package com.example.coloymyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var root: ConstraintLayout
    private lateinit var boxOneText: TextView
    private lateinit var boxTwoText: TextView
    private lateinit var boxThreeText: TextView
    private lateinit var boxFourText: TextView
    private lateinit var boxFiveText: TextView
    private lateinit var redButton: Button
    private lateinit var yellowButton: Button
    private lateinit var greenButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        root = findViewById(R.id.constraint_layout)
        boxOneText = findViewById(R.id.box_one_txt)
        boxTwoText = findViewById(R.id.box_two_txt)
        boxThreeText = findViewById(R.id.box_three_txt)
        boxFourText = findViewById(R.id.box_four_txt)
        boxFiveText = findViewById(R.id.box_five_txt)
        redButton = findViewById(R.id.red_btn)
        yellowButton = findViewById(R.id.yellow_btn)
        greenButton = findViewById(R.id.green_btn)

        val clickableListView = listOf(root, boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, redButton, yellowButton, greenButton)
        for (item in clickableListView)
            item.setOnClickListener { makeColor(it) }
    }

    private fun makeColor(view: View) {
        when(view.id) {
            /* Color TextView after being pressed */
            R.id.box_one_txt -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_txt -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_txt -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_txt -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_txt -> view.setBackgroundColor(Color.BLUE)

            /* Set new color after pressing the buttons */
            R.id.red_btn -> boxThreeText.setBackgroundColor(resources.getColor(R.color.my_red))
            R.id.yellow_btn -> boxFourText.setBackgroundColor(resources.getColor(R.color.my_yellow))
            R.id.green_btn -> boxFiveText.setBackgroundColor(resources.getColor(R.color.my_green))

            /* Color ConstraintLayout after pressing it */
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}