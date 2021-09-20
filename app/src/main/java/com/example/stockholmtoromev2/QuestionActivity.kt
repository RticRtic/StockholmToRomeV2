package com.example.stockholmtoromev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {

    lateinit var userSeeFlagView: ImageView
    lateinit var userSeeQuestionView: TextView
    lateinit var userButton1: Button
    lateinit var userButton2: Button
    lateinit var userButton3: Button
    lateinit var userButton4: Button





    var diffrentQuestions = QuestionsList()
    var currentQuestionIndex = 0
    var userAnswer = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        userSeeFlagView = findViewById(R.id.flaglv)
        userSeeQuestionView = findViewById(R.id.textView)




        userButton1 = findViewById(R.id.button1)
        userButton1.setOnClickListener() {
            userAnswer = 1
            correctAnswer()

            }
        userButton2 = findViewById(R.id.button2)
         userButton2.setOnClickListener() {
          userAnswer = 2
          correctAnswer()
        }
        userButton3 = findViewById(R.id.button3)
        userButton3.setOnClickListener(){
            userAnswer = 3
            correctAnswer()
        }
        userButton4 = findViewById(R.id.button4)
        userButton4.setOnClickListener() {
            userAnswer = 4
            correctAnswer()
        }

        val q = diffrentQuestions.listOfQuestions[currentQuestionIndex]
        userSeeFlagView.setImageResource(q.image)
        userSeeQuestionView.setText(q.questions)
        userButton1.setText(q.answer[0])
        userButton2.setText(q.answer[1])
        userButton3.setText(q.answer[2])
        userButton4.setText(q.answer[3])







        // currentQuestionIndex ++



       //nextQuestion()
       //correctAnswer()
    }



    fun nextQuestion() {
     val q = diffrentQuestions.listOfQuestions[currentQuestionIndex]
        currentQuestionIndex ++
        userSeeFlagView.setImageResource(q.image)
        userSeeQuestionView.setText(q.questions)
        userButton1.setText(q.answer[0])
        userButton2.setText(q.answer[1])
        userButton3.setText(q.answer[2])
        userButton4.setText(q.answer[3])


    }
    fun correctAnswer() {

        val answer = diffrentQuestions.listOfQuestions[currentQuestionIndex]

        if(answer.correctAnswer == userAnswer) {
            Log.d("!!!", "Correct answer")
            nextQuestion()
        }else borderControllQ()


    }

    fun borderControllQ(){
        Log.d("!!!","Wrong answer" )
    }


}