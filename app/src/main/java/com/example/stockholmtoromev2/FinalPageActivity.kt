package com.example.stockholmtoromev2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.stockholmtoromev2.database.AppDatabase
import com.example.stockholmtoromev2.database.Qindex
import com.example.stockholmtoromev2.highscore.HighScoreActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FinalPageActivity : AppCompatActivity(), CoroutineScope {

    val TAG = "!!!"

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    lateinit var db: AppDatabase
    var getUsername: String = ""
    var indexTrackerDestination: Int = 0
    var indexTrackerBorderControll: Int = 0
    var indexTrackerLastChance: Int = 0


    var currentQuestionIndex = 0
    var currentQuestionsIndexBc = 0
    var currentQuestionIndexLc = 0

    lateinit var userSeeGameNameView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        

        job = Job()

        db = AppDatabase.getInstance(this)

        getUsername = intent.getStringExtra("username").toString()
        indexTrackerDestination = intent.getIntExtra("destinationIndexControllTracker",currentQuestionIndex)
        indexTrackerBorderControll = intent.getIntExtra("borderControllIndexControllTracker",currentQuestionsIndexBc)
        indexTrackerLastChance = intent.getIntExtra("lastChanceIndexControllTracker",currentQuestionIndexLc)

        Log.d(TAG, "onCreate:Finalpage $getUsername")
        Log.d(TAG, "onCreate: Finalpage destinationIndexTracker: $indexTrackerDestination")
        Log.d(TAG, "onCreate: Finalpage borderControllIndexTracker: $indexTrackerBorderControll")
        Log.d(TAG, "onCreate: Finalpage lastChanceIndexGTracler: $indexTrackerLastChance")


        setContentView(R.layout.activity_final_page)
        userSeeGameNameView = findViewById(R.id.textView2)

        val playAgainButton = findViewById<Button>(R.id.playAgainButton)
        playAgainButton.setBackgroundColor(Color.BLUE)
        playAgainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val hangOutWithPopeButton = findViewById<Button>(R.id.pope_button)
        hangOutWithPopeButton.setBackgroundColor(Color.BLUE)
        hangOutWithPopeButton.setOnClickListener {
            val intent = Intent(this, HangOutWithPopeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val highscoreButton = findViewById<Button>(R.id.highscoreButton)
        highscoreButton.setBackgroundColor(Color.BLUE)
        highscoreButton.setOnClickListener {
            val intent = Intent(this, HighScoreActivity::class.java)
            intent.putExtra("username",getUsername)
            intent.putExtra("destinationIndexControllTracker",indexTrackerDestination)
            intent.putExtra("borderControllIndexControllTracker",indexTrackerBorderControll)
            intent.putExtra("lastChanceIndexControllTracker",indexTrackerLastChance)
            startActivity(intent)
            finish()
        }



    }



}