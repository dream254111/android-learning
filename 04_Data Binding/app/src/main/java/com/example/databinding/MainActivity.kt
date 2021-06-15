package com.example.databinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var nicknameEdit: EditText
    private lateinit var nicknameText: TextView
    private lateinit var doneButton: Button

    private lateinit var inputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        nicknameEdit = findViewById(R.id.nickname_edit)
        nicknameText = findViewById(R.id.nickname_txt)
        doneButton = findViewById(R.id.done_btn)

        nicknameText.setOnClickListener {  onNicknameTextClick(it)}
        doneButton.setOnClickListener { onDoneButtonClick(it) }
    }

    private fun onDoneButtonClick(view: View) {
        nicknameText.text = nicknameEdit.text

        nicknameText.visibility = View.VISIBLE
        nicknameEdit.visibility = View.INVISIBLE
        doneButton.visibility = View.GONE

        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun onNicknameTextClick(view: View) {
        nicknameText.visibility = View.INVISIBLE
        nicknameEdit.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE

        nicknameEdit.requestFocus()
        inputMethodManager.showSoftInput(nicknameEdit, 0)
    }
}