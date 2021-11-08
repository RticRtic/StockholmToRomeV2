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
    lateinit var recyclerView: RecyclerView


    val TAG = "!!!"

    var getUsername: String = ""
    var indexTrackerDestination: Int = 0
    var indexTrackerBorderControll: Int = 0
    var indexTrackerLastChanceControll: Int = 0


    var currentQuestionIndex: Int = 0
    var currentQuestionsIndexBc: Int = 0
    var currentQuestionIndexLc: Int = 0


    var players = mutableListOf<Qindex>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        job = Job()
        db = AppDatabase.getInstance(this)


        getUsername = intent.getStringExtra("username").toString()
        indexTrackerDestination = intent.getIntExtra("destinationIndexControllTracker",currentQuestionIndex)
        indexTrackerBorderControll = intent.getIntExtra("borderControllIndexControllTracker",currentQuestionsIndexBc)
        indexTrackerLastChanceControll = intent.getIntExtra("lastChanceIndexControllTracker",currentQuestionIndexLc)

        Log.d(TAG, "onCreate: indexTrackerDestination: $indexTrackerDestination")
        Log.d(TAG, "onCreate: indexTrackerLastChance: $indexTrackerLastChanceControll")
        Log.d(TAG, "onCreate: indexTrackerBorderControll: $indexTrackerBorderControll")

        when{

            indexTrackerDestination == 5 -> where = "Made it to Rome"

        }
        when{
            indexTrackerBorderControll == 0 -> where = "Made it to Denmark"
            indexTrackerBorderControll == 1 -> where = "Made it to Germany"
            indexTrackerBorderControll == 2 -> where = "Made it to Switzerland"
            indexTrackerBorderControll == 3 -> where = "Made it to Italy"
        }
        when{
            indexTrackerLastChanceControll == 0 -> where = "Made it to Denmark"
            indexTrackerLastChanceControll == 1 -> where = "Made it to Germany"
            indexTrackerLastChanceControll == 2 -> where = "Made it to Switzerland"
            indexTrackerLastChanceControll == 3 -> where = "Made it to Italy"
        }



        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = HighScoreRecyclerView(this, players)
        recyclerView.adapter = adapter

        addIndex(Qindex(0,getUsername,where))
       

        loadAllPlayers()

    }
    fun addIndex(index: Qindex) {

        launch(Dispatchers.IO) {
            db.qindexDao.insert(index)

        }
    }
    fun loadAllPlayers() {
        val gamers = async(Dispatchers.IO) {
            db.qindexDao.getAll()

        }
        launch {
            val list = gamers.await().toMutableList()
            players.addAll(list)

            recyclerView.adapter?.notifyDataSetChanged()

        }
    }

}