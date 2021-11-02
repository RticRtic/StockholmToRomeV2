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

    var players= mutableListOf<HiScore>(HiScore("Manne", "Denmark"),
    HiScore("Torsten", "Rome"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        job = Job()
        db = AppDatabase.getInstance(this)


/*
        var name = db.qindex.name
        when{
            db.qindex.currentIndex == 0 -> where = "Missed the train"
            db.qindex.currentIndex == 1 -> where = "Denmark"
            db.qindex.currentIndex == 2 -> where = "Germany"
            db.qindex.currentIndex == 3 -> where = "Switzerland"
            db.qindex.currentIndex == 4 -> where = "Italy"
            db.qindex.currentIndex >= 5 -> where = "Rome"
        }
*/
        //  users.add(HiScore(name, where))

       val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = HighScoreRecyclerView(this, players)
        recyclerView.adapter = adapter

    }
/*
    fun addIndex(index: Qindex) {

        launch(Dispatchers.IO) {
            db.qindexDao.insert(index)

        }
    }

 */
}