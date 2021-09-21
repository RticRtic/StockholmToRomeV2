package com.example.stockholmtoromev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.view.View
import android.widget.*

class QuestionActivity : AppCompatActivity() {

    lateinit var userSeeFlagView: ImageView
    lateinit var userSeeQuestionView: TextView
    lateinit var userButton1: Button
    lateinit var userButton2: Button
    lateinit var userButton3: Button
    lateinit var userButton4: Button


    var diffrentQuestions = QuestionsList()
    var borderControlQuestions = QuestionsListBorderControll()
    var userPressAnswer: Int = 0
    var currentQuestionIndex = 0
    var currentQuestionsIndexBc = 0
    var q: Destination = diffrentQuestions.listOfQuestions[currentQuestionIndex]
    var bC: BorderControll = borderControlQuestions.listOfQuestionsBC[currentQuestionsIndexBc]



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        userSeeFlagView = findViewById(R.id.flaglv)
        userSeeQuestionView = findViewById(R.id.textView)


        userButton1 = findViewById(R.id.button1)
        userButton1.setOnClickListener {
            userPressAnswer = 1
            checkIfCorrectAnswer()



        }
        userButton2 = findViewById(R.id.button2)
        userButton2.setOnClickListener {
            userPressAnswer = 2
            checkIfCorrectAnswer()


        }
        userButton3 = findViewById(R.id.button3)
        userButton3.setOnClickListener {
            userPressAnswer = 3
            checkIfCorrectAnswer()




        }
        userButton4 = findViewById(R.id.button4)
        userButton4.setOnClickListener {
            userPressAnswer = 4
            checkIfCorrectAnswer()



        }


        setQuestion()


    }


    fun setQuestion() {
        q = diffrentQuestions.listOfQuestions[currentQuestionIndex]

        userSeeFlagView.setImageResource(q.image)
        userSeeQuestionView.setText(q.question)
        userButton1.setText(q.answer[0])
        userButton2.setText(q.answer[1])
        userButton3.setText(q.answer[2])
        userButton4.setText(q.answer[3])


    }


    fun checkIfCorrectAnswer() {
        if (q.correctAnswer == userPressAnswer) {
            currentQuestionIndex++


            when {
                currentQuestionIndex <= diffrentQuestions.listOfQuestions.size ->
                    setQuestion()
            }


        } else {
            val question = diffrentQuestions.listOfQuestions.get(currentQuestionIndex)
            if (question.correctAnswer != userPressAnswer) {
                checkBorderControlQuestions()
                setBorderControlQuestion()


            }
        }


    }

    fun setBorderControlQuestion() {
    bC = borderControlQuestions.listOfQuestionsBC[currentQuestionsIndexBc]
        userSeeFlagView.setImageResource(bC.image)
        userSeeQuestionView.setText(bC.question)
        userButton1.setText(bC.answer[0])
        userButton2.setText(bC.answer[1])
        userButton3.setText(bC.answer[2])
        userButton4.setText(bC.answer[3])


    }

    fun checkBorderControlQuestions() {

        if (bC.correctAnswer == userPressAnswer) {



            when {
                currentQuestionsIndexBc <= borderControlQuestions.listOfQuestionsBC.size ->
                    setBorderControlQuestion()

            }


        } else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)


            }

        }

    }

