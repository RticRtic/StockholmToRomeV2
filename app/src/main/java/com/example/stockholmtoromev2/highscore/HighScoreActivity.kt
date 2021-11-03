package com.example.stockholmtoromev2.highscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockholmtoromev2.R
import com.example.stockholmtoromev2.database.AppDatabase
import com.example.stockholmtoromev2.database.Qindex
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HighScoreActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    lateinit var db: AppDatabase
    lateinit var where: String


    val TAG = "!!!"

    var getUsername: String = ""
    var indexTracker: Int = 0
    var currentQuestionIndex: Int = 0

    var players= mutableListOf<HiScore>(HiScore(getUsername, "Denmark"),
    HiScore("Torsten", "Rome"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        job = Job()
        db = AppDatabase.getInstance(this)


        getUsername = intent.getStringExtra("username").toString()
        indexTracker = intent.getIntExtra("destinationIndexTracker",currentQuestionIndex)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = HighScoreRecyclerView(this, players)
        recyclerView.adapter = adapter

        addIndex(Qindex(0,indexTracker,getUsername))
        Log.d(TAG, "onCreate:HighScoreActivity $getUsername")
        Log.d(TAG, "onCreate: HighScoreActivity $indexTracker")

    }
    fun addIndex(index: Qindex) {

        launch(Dispatchers.IO) {
            db.qindexDao.insert(index)

        }
    }
}