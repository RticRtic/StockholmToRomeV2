package com.example.stockholmtoromev2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class UserMadeItToPageActivity : AppCompatActivity() {

    lateinit var userSeeFlagView: ImageView
    lateinit var userSeeTextView: TextView

    var flaglist = QuestionsList()
    var f: Destination = flaglist.listOfQuestions[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_made_it_to_page)

        userSeeFlagView = findViewById(R.id.youLostImageView)
        userSeeTextView = findViewById(R.id.youLostTextView)

        val button = findViewById<Button>(R.id.youLostButton)
        button.setBackgroundColor(Color.BLUE)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        userMadeItToPage()


    }
    fun userMadeItToPage() {
        val intent = getIntent()
        val flagView = intent.getIntExtra("index",0)
        f = flaglist.listOfQuestions[flagView]
        userSeeFlagView.setImageResource(f.image)
        userSeeTextView.setText("You made it to ${f.country}")

    }






}