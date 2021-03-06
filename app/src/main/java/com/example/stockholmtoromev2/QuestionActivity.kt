package com.example.stockholmtoromev2

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.os.Handler
import android.util.Log

import android.widget.*
import androidx.room.Insert
import androidx.room.Query
import com.example.stockholmtoromev2.database.AppDatabase
import com.example.stockholmtoromev2.database.Qindex
import com.example.stockholmtoromev2.database.QindexDao
import kotlinx.coroutines.*
import java.util.*
import kotlin.concurrent.schedule
import kotlin.coroutines.CoroutineContext

class QuestionActivity : AppCompatActivity(), CoroutineScope {


    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    lateinit var db : AppDatabase

    val TAG = "!!!"

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
    var mediaPlayer: MediaPlayer? = null

    var getUsername : String? = ""


    var isBorderQuestion = false
    var isLastChanceQuestions = false

    var q: Destination = diffrentQuestions.listOfQuestions[currentQuestionIndex]
    var bC: BorderControll = borderControlQuestions.listOfQuestionsBC[currentQuestionsIndexBc]
    var lC: LastChance = lastChanceQuestions.listOfQuestionslC[currenQuestionsIndexLc]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        userSeeFlagView = findViewById(R.id.flaglv)
        job = Job()
        db = AppDatabase.getInstance(this)

        userSeeQuestionView = findViewById(R.id.textView)
        startMedia()

        getUsername = intent.getStringExtra("username")

        Log.d(TAG, "onCreate:Questionactivity $getUsername")
        Log.d(TAG, "onCreate:QuestionActivity IndexTracker: $currentQuestionIndex")


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
        restoreButtonColor()
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
        restoreButtonColor()
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
        restoreButtonColor()
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
        userPressButtonColorGreen()

        if (q.correctAnswer == userPressAnswer) {
            // Disabla knappar h??r
                disableButtons()
            Handler().postDelayed({

                currentQuestionIndex++
                Log.d(TAG, "checkIfCorrectAnswer IndexTracker: $currentQuestionIndex")
                currentQuestionsIndexBc++
                currenQuestionsIndexLc++


                if (currentQuestionIndex <= diffrentQuestions.listOfQuestions.size) {

                    setQuestion()
                    // Connecta knappar
                    enableButtons()
                }
            }, 2000)


        } else {
            userPressButtonColorRed()
            disableButtons()
            Handler().postDelayed({
                setBorderControlQuestion()
                enableButtons()
            }, 2000)
        }

    }

    fun checkBorderControlQuestions() {
        userPressBcButtonColorGreen()

        if (bC.correctAnswer == userPressAnswer) {
            disableButtons()
            Handler().postDelayed({
                Log.d(TAG, "checkBorderControllQuestion IndexTracker: $currentQuestionsIndexBc")


                if (currentQuestionsIndexBc <= borderControlQuestions.listOfQuestionsBC.size) {

                    setLastChanceQuestion()
                    enableButtons()
                }
            }, 2000)


        } else {
            userPressButtonColorRed()
            disableButtons()
            Handler().postDelayed({
                startYoulostPage()
            },500)
        }

    }

    fun checkLastChanceQuestions() {
        userPressLcButtonColorGreen()

        if (lC.correctAnswer == userPressAnswer) {
            disableButtons()
            Handler().postDelayed({

                currentQuestionIndex++
                currentQuestionsIndexBc++
                currenQuestionsIndexLc++
                Log.d(TAG, "CheckLastChance IndexTracker: $currenQuestionsIndexLc")


                if (currenQuestionsIndexLc <= lastChanceQuestions.listOfQuestionslC.size) {
                    setQuestion()
                    enableButtons()

                }
            }, 2000)

        } else {
            userPressButtonColorRed()
            disableButtons()
            Handler().postDelayed({
                startYoulostPage()
            },500)
        }
    }


    fun questionType() {



        if (currentQuestionIndex == 4 && q.correctAnswer == userPressAnswer) {
            currentQuestionIndex++
            userPressButtonColorGreen()
            disableButtons()
            Handler().postDelayed({
                val finalintent = Intent(this, FinalPageActivity::class.java)

                finalintent.putExtra("username",getUsername)
                finalintent.putExtra("destinationIndexControllTracker",currentQuestionIndex)
                finalintent.putExtra("borderControllIndexControllTracker",currentQuestionsIndexBc)
                finalintent.putExtra("lastChanceIndexControllTracker",currenQuestionsIndexLc)

               // Log(TAG, "questionType:QuestionActivity $getUsername")
                Log.d(TAG, "questionType: QuestionActivity IndexTracker: $currentQuestionIndex")

                mediaPlayer?.stop()
                startActivity(finalintent)
            },2000)

        } else if (currentQuestionIndex == 4 && q.correctAnswer != userPressAnswer) {
          //  currentQuestionIndex++ // Kanske beh??ver ta bort denna?
            mediaPlayer?.stop()
            startYoulostPage()
            disableButtons()

        } else if (isBorderQuestion == false && isLastChanceQuestions == false) {
            checkIfCorrectAnswer()
        } else if (isBorderQuestion == true && isLastChanceQuestions == false) {
            checkBorderControlQuestions()

        } else if (isBorderQuestion == false && isLastChanceQuestions == true) {
            checkLastChanceQuestions()

        }
    }

    fun restoreButtonColor() {
        userButton1.setBackgroundColor(Color.BLUE)
        userButton2.setBackgroundColor(Color.BLUE)
        userButton3.setBackgroundColor(Color.BLUE)
        userButton4.setBackgroundColor(Color.BLUE)
    }

    fun userPressButtonColorGreen() {
        when (q.correctAnswer) {
            1 -> userButton1.setBackgroundColor(Color.GREEN)
            2 -> userButton2.setBackgroundColor(Color.GREEN)
            3 -> userButton3.setBackgroundColor(Color.GREEN)
            4 -> userButton4.setBackgroundColor(Color.GREEN)

        }
    }



    fun userPressBcButtonColorGreen() {
        when (bC.correctAnswer) {
            1 -> userButton1.setBackgroundColor(Color.GREEN)
            2 -> userButton2.setBackgroundColor(Color.GREEN)
            3 -> userButton3.setBackgroundColor(Color.GREEN)
            4 -> userButton4.setBackgroundColor(Color.GREEN)

        }

    }
    fun userPressButtonColorRed() {
        when (userPressAnswer) {
            1 -> userButton1.setBackgroundColor(Color.RED)
            2 -> userButton2.setBackgroundColor(Color.RED)
            3 -> userButton3.setBackgroundColor(Color.RED)
            4 -> userButton4.setBackgroundColor(Color.RED)

        }

    }

    fun userPressLcButtonColorGreen() {
        when (lC.correctAnswer) {
            1 -> userButton1.setBackgroundColor(Color.GREEN)
            2 -> userButton2.setBackgroundColor(Color.GREEN)
            3 -> userButton3.setBackgroundColor(Color.GREEN)
            4 -> userButton4.setBackgroundColor(Color.GREEN)

        }
    }
    fun startMedia() {
        mediaPlayer = MediaPlayer.create(this, R.raw.backgroundmusic)
        mediaPlayer?.setOnPreparedListener {
            mediaPlayer?.start()
        }
    }

    fun startYoulostPage(){
        userPressButtonColorRed()
        Handler().postDelayed({
            val intent = Intent(this, UserMadeItToPageActivity::class.java)
            intent.putExtra("destinationIndexControllTracker", currentQuestionIndex)
            intent.putExtra("borderControllIndexControllTracker",currentQuestionsIndexBc)
            intent.putExtra("lastChanceIndexControllTracker",currenQuestionsIndexLc)

            intent.putExtra("index",currentQuestionIndex)
            intent.putExtra("username",getUsername)
            mediaPlayer?.stop()
            startActivity(intent)
        }, 2000)
    }


    fun enableButtons() {
        userButton1.isEnabled = true
        userButton2.isEnabled = true
        userButton3.isEnabled = true
        userButton4.isEnabled = true

    }
    fun disableButtons() {
        userButton1.isEnabled = false
        userButton2.isEnabled = false
        userButton3.isEnabled = false
        userButton4.isEnabled = false

    }

}








