package com.example.stockholmtoromev2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.graphics.toColor
import java.util.*
import kotlin.concurrent.schedule

class QuestionActivity : AppCompatActivity() {

    lateinit var userSeeFlagView: ImageView
    lateinit var userSeeQuestionView: TextView
    lateinit var userButton1: Button
    lateinit var userButton2: Button
    lateinit var userButton3: Button
    lateinit var userButton4: Button


    var diffrentQuestions = QuestionsList()
    var borderControlQuestions = QuestionsListBorderControll()
    var lastChanceQuestions = LastChanceQuestionsList()

    var userPressAnswer: Int = 0
    var currentQuestionIndex = 0
    var currentQuestionsIndexBc = 0
    var currenQuestionsIndexLc = 0


    var isBorderQuestion = false
    var isLastChanceQuestions = false

    var q: Destination = diffrentQuestions.listOfQuestions[currentQuestionIndex]
    var bC: BorderControll = borderControlQuestions.listOfQuestionsBC[currentQuestionsIndexBc]
    var lC: LastChance = lastChanceQuestions.listOfQuestionslC[currenQuestionsIndexLc]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        userSeeFlagView = findViewById(R.id.flaglv)
        userSeeQuestionView = findViewById(R.id.textView)


        userButton1 = findViewById(R.id.button1)
        userButton1.setOnClickListener {
            userPressAnswer = 1
            questionType()

        }
        userButton2 = findViewById(R.id.button2)
        userButton2.setOnClickListener {
            userPressAnswer = 2
            questionType()

        }
        userButton3 = findViewById(R.id.button3)
        userButton3.setOnClickListener {
            userPressAnswer = 3
            questionType()

        }
        userButton4 = findViewById(R.id.button4)
        userButton4.setOnClickListener {
            userPressAnswer = 4
            questionType()

        }

        setQuestion()



    }


    fun setQuestion() {
        isBorderQuestion = false
        isLastChanceQuestions = false
        q = diffrentQuestions.listOfQuestions[currentQuestionIndex]
        userSeeFlagView.setImageResource(q.image)
        userSeeQuestionView.setText(q.question)
        userButton1.setText(q.answer[0])
        userButton2.setText(q.answer[1])
        userButton3.setText(q.answer[2])
        userButton4.setText(q.answer[3])


    }

    fun setBorderControlQuestion() {
        isBorderQuestion = true
        isLastChanceQuestions = false
        bC = borderControlQuestions.listOfQuestionsBC[currentQuestionsIndexBc]
        userSeeFlagView.setImageResource(bC.image)
        userSeeQuestionView.setText(bC.question)
        userButton1.setText(bC.answer[0])
        userButton2.setText(bC.answer[1])
        userButton3.setText(bC.answer[2])
        userButton4.setText(bC.answer[3])

    }

    fun setLastChanceQuestion() {
        isBorderQuestion = false
        isLastChanceQuestions = true
        lC = lastChanceQuestions.listOfQuestionslC[currenQuestionsIndexLc]
        userSeeFlagView.setImageResource(lC.image)
        userSeeQuestionView.setText(lC.question)
        userButton1.setText(lC.answer[0])
        userButton2.setText(lC.answer[1])
        userButton3.setText(lC.answer[2])
        userButton4.setText(lC.answer[3])
    }

    fun checkIfCorrectAnswer() {


        if (q.correctAnswer == userPressAnswer) {
            currentQuestionIndex++
            currentQuestionsIndexBc++
            currenQuestionsIndexLc++

            when (q.correctAnswer) {
                1 -> userButton1.setBackgroundColor(Color.GREEN)
                2 -> userButton2.setBackgroundColor(Color.GREEN)
                3 -> userButton3.setBackgroundColor(Color.GREEN)
                4 -> userButton4.setBackgroundColor(Color.GREEN)
            }


                if (currentQuestionIndex <= diffrentQuestions.listOfQuestions.size) {

                    setQuestion()



                }


        } else {
            when(userPressAnswer) {
                1 -> userButton1.setBackgroundColor(Color.RED)
                2 -> userButton2.setBackgroundColor(Color.RED)
                3 -> userButton3.setBackgroundColor(Color.RED)
                4 -> userButton4.setBackgroundColor(Color.RED)
            }
            setBorderControlQuestion()
        }

    }

    fun checkBorderControlQuestions() {
        if (bC.correctAnswer == userPressAnswer) {


            if (currentQuestionsIndexBc <= borderControlQuestions.listOfQuestionsBC.size) {
                setLastChanceQuestion()
            }


        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }

    fun checkLastChanceQuestions() {
        if (lC.correctAnswer == userPressAnswer) {
            currentQuestionIndex++
            currentQuestionsIndexBc++
            currenQuestionsIndexLc++


            if (currenQuestionsIndexLc <= lastChanceQuestions.listOfQuestionslC.size) {
                setQuestion()

            }

        } else {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }



    fun questionType() {

        if (currentQuestionIndex == 4 && q.correctAnswer == userPressAnswer) {
            val finalintent = Intent(this, FinalPageActivity::class.java)
            startActivity(finalintent)
        }else if (currentQuestionIndex == 4 && q.correctAnswer != userPressAnswer){
            val mainintent = Intent(this, MainActivity::class.java)
            startActivity(mainintent)

        }else if (isBorderQuestion == false && isLastChanceQuestions == false) {
            checkIfCorrectAnswer()
        } else if (isBorderQuestion == true && isLastChanceQuestions == false) {
            checkBorderControlQuestions()

        } else if (isBorderQuestion == false && isLastChanceQuestions == true) {
            checkLastChanceQuestions()

        }
    }









}


