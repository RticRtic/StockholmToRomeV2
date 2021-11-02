package com.example.stockholmtoromev2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var userSeeGameNameView: TextView
    lateinit var userSeeImageView: ImageView
    lateinit var userSeeWelcomeTextView: TextView
    lateinit var usernameTextView: EditText

    val TAG = "!!!"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userSeeGameNameView = findViewById(R.id.userSeeGameNameTv)
        userSeeImageView = findViewById(R.id.stockholm_picture)
        userSeeWelcomeTextView = findViewById(R.id.questionTv)
        usernameTextView = findViewById(R.id.usernameTextView)

        userSeeWelcomeTextView.text = "In this travelquiz you’re going from Stockholm to Rome. " +
                                      "On each stop on the way to Rome there will be a specific question for that country."+
                                      " To travel along you have to guess the right answer on each stop along the way. " +
                                      "If you pick the wrong answer you will be sent to the bordercontrol."+
                                      " There you have to answer correctly to continue on your journey. " +
                                      "If you answer correct you have to answer to a new question about the same country. " +
                                      "You have to answer correct or you´ll be sent back to Stockholm"



        val button = findViewById<Button>(R.id.startButton)
        button.setBackgroundColor(Color.BLUE)

        button.setOnClickListener {

            val intent = Intent(this, QuestionActivity::class.java)
            val username = usernameTextView.text.toString()
            intent.putExtra("username", username)

            Log.d(TAG, "onCreate: $username")
            startActivity(intent)
            finish()
            }
        }
    }







