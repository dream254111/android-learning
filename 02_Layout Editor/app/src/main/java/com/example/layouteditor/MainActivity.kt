package com.example.layouteditor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var doneButton: Button
    private lateinit var nicknameEdit: EditText
    private lateinit var nicknameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById(R.id.done_btn)
        nicknameEdit = findViewById(R.id.nickname_edit)
        nicknameText = findViewById(R.id.nickname_txt)

        doneButton.setOnClickListener { onDoneButtonClick(it) }
        nicknameText.setOnClickListener{ onNicknameTextClick(it) }
    }

    private fun onDoneButtonClick(view: View) {
        nicknameText.text = nicknameEdit.text

        view.visibility = View.GONE
        nicknameEdit.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun onNicknameTextClick(view: View) {
        view.visibility = View.GONE
        nicknameEdit.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
    }
}