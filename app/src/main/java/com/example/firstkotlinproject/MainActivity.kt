package com.example.firstkotlinproject

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val button:Button=findViewById(R.id.button)
        val field:TextInputEditText=findViewById(R.id.field)
        field.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                button.isEnabled = field.text?.isNotEmpty() == true
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        button.setOnClickListener {

            val intent:Intent =Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("http://${field.text.toString()}")
            startActivity(intent)
        }
    }

}