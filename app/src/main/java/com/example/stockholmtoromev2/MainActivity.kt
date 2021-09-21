package com.example.stockholmtoromev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var userSeeGameNameView: TextView
    lateinit var userSeeImageView: ImageView
    lateinit var userSeeWelcomeTextView: TextView
    lateinit var userTypeInNameView: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userSeeGameNameView = findViewById(R.id.userSeeGameNameTv)
        userSeeImageView = findViewById(R.id.flagIv)
        userSeeWelcomeTextView = findViewById(R.id.questionTv)
        userTypeInNameView = findViewById(R.id.userTypeNameEt)


        val button = findViewById<Button>(R.id.startButton)
        button.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }





