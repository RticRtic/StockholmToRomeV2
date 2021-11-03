package com.example.stockholmtoromev2.highscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    var players = mutableListOf<HiScore>(
        HiScore("Manne", "Denmark"),
        HiScore("Torsten", "Rome")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        job = Job()
        db = AppDatabase.getInstance(this)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = HighScoreRecyclerView(this, players)
        recyclerView.adapter = adapter

    }
}