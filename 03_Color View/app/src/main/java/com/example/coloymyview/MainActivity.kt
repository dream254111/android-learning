package com.example.coloymyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var root: ConstraintLayout
    private lateinit var boxOneText: TextView
    private lateinit var boxTwoText: TextView
    private lateinit var boxThreeText: TextView
    private lateinit var boxFourText: TextView
    private lateinit var boxFiveText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        root = findViewById(R.id.constraint_layout)
        boxOneText = findViewById(R.id.box_one_txt)
        boxTwoText = findViewById(R.id.box_two_txt)
        boxThreeText = findViewById(R.id.box_three_txt)
        boxFourText = findViewById(R.id.box_four_txt)
        boxFiveText = findViewById(R.id.box_five_txt)

        val clickableListView = listOf(root, boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText)
        for (item in clickableListView)
            item.setOnClickListener { makeColor(it) }
    }

    private fun makeColor(view: View) {
        when(view.id) {
            R.id.box_one_txt -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_txt -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_txt -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_txt -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_txt -> view.setBackgroundColor(Color.BLUE)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}