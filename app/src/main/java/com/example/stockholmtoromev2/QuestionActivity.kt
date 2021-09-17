package com.example.stockholmtoromev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {

    lateinit var userSeeFlagView: ImageView
    lateinit var userSeeQuestionView: TextView
    lateinit var userButton1: Button
    lateinit var userButton2: Button
    lateinit var UserButton3: Button
    lateinit var UserButton4: Button


    var diffrentQuestions = QuestionsList()
    var currentQuestionIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
git
        userSeeFlagView = findViewById(R.id.flaglv)




       // currentQuestionIndex ++



        nextQuestion()
    }



    fun nextQuestion() {
     var q = diffrentQuestions.listOfQuestions[currentQuestionIndex]
        userSeeFlagView.setImageResource(q.image)

    }


}