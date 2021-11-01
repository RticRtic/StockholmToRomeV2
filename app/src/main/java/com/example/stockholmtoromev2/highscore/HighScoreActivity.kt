package com.example.stockholmtoromev2.highscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockholmtoromev2.R
import com.example.stockholmtoromev2.database.AppDatabase
import com.example.stockholmtoromev2.database.Qindex
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class HighScoreActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var currentIndexDatabase : Qindex? = null
    lateinit var db : AppDatabase
    lateinit var where: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        var users = mutableListOf<HiScore>(HiScore("Manne", "Denmark"))

        var name = db.qindex.name
        when{
            db.qindex.current == 0 -> where = "Missed the train"
            db.qindex.current == 1 -> where = "Denmark"
            db.qindex.current == 2 -> where = "Germany"
            db.qindex.current == 3 -> where = "Switzerland"
            db.qindex.current == 4 -> where = "Italy"
            db.qindex.current >= 5 -> where = "Rome"
        }

        users.add(HiScore(name, where))

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = HighScoreRecycleView(this, users)
        recyclerView.adapter = adapter

    }
}