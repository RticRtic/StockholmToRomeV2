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
    var GetUsername: String = ""
    var indexTracker: Int = 0
    var currentQuestionIndex = 0


    lateinit var userSeeGameNameView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        

        job = Job()

        db = AppDatabase.getInstance(this)

        GetUsername = intent.getStringExtra("username").toString()
        indexTracker = intent.getIntExtra("destinationIndexTracker",currentQuestionIndex)
        Log.d(TAG, "onCreate:Finalpage $GetUsername")
        Log.d(TAG, "onCreate: Finalpage $indexTracker")

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
            startActivity(intent)
            finish()
        }

        addIndex(Qindex(0,indexTracker,GetUsername))
        Log.d(TAG, "onCreate:Finalpage $GetUsername")

    }
    fun addIndex(index: Qindex) {

        launch(Dispatchers.IO) {
            db.qindexDao.insert(index)

        }
    }


}