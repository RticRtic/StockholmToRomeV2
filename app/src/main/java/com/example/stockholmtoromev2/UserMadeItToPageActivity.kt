package com.example.stockholmtoromev2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stockholmtoromev2.database.AppDatabase
import com.example.stockholmtoromev2.database.Qindex
import com.example.stockholmtoromev2.highscore.HighScoreActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UserMadeItToPageActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    val TAG = "!!!"

    lateinit var userSeeFlagView: ImageView
    lateinit var userSeeTextView: TextView
    lateinit var db: AppDatabase
//    lateinit var recyclerView: RecyclerView
    lateinit var where: String

    var flaglist = QuestionsList()
    var f: Destination = flaglist.listOfQuestions[0]
    var getUsername = ""
    var indexTrackerDestination = 0
    var indexTrackerBorderControll = 0
    var indexTrackerLastChanceControll = 0

    var currentIndexTrackerDc = 0
    var currentIndexTrackerBc = 0
    var currentIndexTrackerLc = 0

    var players = mutableListOf<Qindex>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_made_it_to_page)

        job = Job()
        db = AppDatabase.getInstance(this)

        getUsername = intent.getStringExtra("username").toString()
        indexTrackerDestination = intent.getIntExtra("destinationIndexControllTracker",currentIndexTrackerDc)
        indexTrackerBorderControll = intent.getIntExtra("borderControllIndexControllTracker",currentIndexTrackerBc)
        indexTrackerLastChanceControll = intent.getIntExtra("lastChanceIndexControllTracker", currentIndexTrackerLc)

        Log.d(TAG, "onCreate: UserMadeItToPage: destination $indexTrackerDestination")
        Log.d(TAG, "onCreate: UserMadeItToPage: bordercontroll $indexTrackerBorderControll")
        Log.d(TAG, "onCreate: UserMadeItToPage: last chance $indexTrackerLastChanceControll")

        userSeeFlagView = findViewById(R.id.youLostImageView)
        userSeeTextView = findViewById(R.id.youLostTextView)

        val mainActivityButton = findViewById<Button>(R.id.youLostButton)
        mainActivityButton.setBackgroundColor(Color.BLUE)

        val hiScoreButton = findViewById<Button>(R.id.hiScoreButton)

        mainActivityButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        hiScoreButton.setOnClickListener {
            val hiScoreIntent = Intent(this, HighScoreActivity::class.java)
            hiScoreIntent.putExtra("username",getUsername)
            hiScoreIntent.putExtra("destinationIndexControllTracker", indexTrackerDestination)
            hiScoreIntent.putExtra("borderControllIndexControllTracker",indexTrackerBorderControll)
            hiScoreIntent.putExtra("lastChanceIndexControllTracker",indexTrackerLastChanceControll)
            startActivity(hiScoreIntent)
        }

        userMadeItToPage()

        //addIndex(Qindex(0,getUsername,where))


       // loadAllPlayers()
    }

    fun userMadeItToPage() {
        val intent = getIntent()
        val flagView = intent.getIntExtra("index",0)
        f = flaglist.listOfQuestions[flagView]
        userSeeFlagView.setImageResource(f.image)
        userSeeTextView.setText("Your journey ends here. You didin't make it in to Rome.")






    }
    /*fun addIndex(index: Qindex) {

        launch(Dispatchers.IO) {
            db.qindexDao.insert(index)

        }
    }

     */
    /*
    fun loadAllPlayers() {
        val gamers = async(Dispatchers.IO) {
            db.qindexDao.getAll()

        }
        launch {
            val list = gamers.await().toMutableList()
            players.addAll(list)

           // recyclerView.adapter?.notifyDataSetChanged()

        }
    }

     */







}