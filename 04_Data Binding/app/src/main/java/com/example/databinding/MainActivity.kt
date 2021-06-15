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
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var inputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        binding.apply {
            doneBtn.setOnClickListener { onDoneButtonClick() }
            nicknameTxt.setOnClickListener { onNicknameTextClick() }
        }
    }

    private fun onDoneButtonClick() {
        binding.apply {
            nicknameTxt.apply {
                text = nicknameEdit.text
                visibility = View.VISIBLE
            }
            nicknameEdit.visibility = View.INVISIBLE
            doneBtn.visibility = View.GONE
        }

        inputMethodManager.hideSoftInputFromWindow(binding.doneBtn.windowToken, 0)
    }

    private fun onNicknameTextClick() {
        binding.apply {
            nicknameTxt.visibility = View.INVISIBLE
            doneBtn.visibility = View.VISIBLE
            nicknameEdit.apply {
                visibility = View.VISIBLE
                requestFocus()
            }
        }

        inputMethodManager.showSoftInput(binding.nicknameEdit, 0)
    }
}