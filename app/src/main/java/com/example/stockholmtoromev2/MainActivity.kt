package com.example.stockholmtoromev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.startButton)
        button.setOnClickListener {
        startQuestionsPage()

        }
    }


    fun startQuestionsPage() {
        val intent = Intent(this, QuestionActivity::class.java)

        startActivity(intent)


    }
}

