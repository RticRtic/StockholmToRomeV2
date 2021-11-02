package com.example.stockholmtoromev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.stockholmtoromev2.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class HangOutWithPopeActivity : AppCompatActivity(){



    lateinit var userSeeImageView: ImageView
    lateinit var userSeeTextView: TextView
    lateinit var nextFactButton : Button

    var diffrentFacts = HangWithThePopeFactList()
    var currentFactIndex = 0
    var userPressButton = 0

    var facts: HangWithThePope = diffrentFacts.listOfFacts[currentFactIndex]



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hang_out_with_pope)

        userSeeImageView = findViewById(R.id.userSeeImage_Iv)
        userSeeTextView = findViewById(R.id.userSeeText_Tv)

        val playAgainButton = findViewById<Button>(R.id.playAgain_Button)
            playAgainButton.setOnClickListener {
               userPressButton = 2
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)


            }
            nextFactButton = findViewById<Button>(R.id.nextFact_Button)
            nextFactButton.setOnClickListener {
                userPressButton = 1
                setNewFact()
            }


        setFacts()
    }


    fun setFacts() {
        facts = diffrentFacts.listOfFacts[currentFactIndex]
        userSeeImageView.setImageResource(facts.image)
        userSeeTextView.setText(facts.facts)


    }
    fun setNewFact() {
        currentFactIndex++
        if(currentFactIndex < diffrentFacts.listOfFacts.size) {
            setFacts()

        } else {
            nextFactButton.setText("We are out of facts press to exit game")
            nextFactButton.setOnClickListener{
                finishAffinity()
            }
        }

    }
}