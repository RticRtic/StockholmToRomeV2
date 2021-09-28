package com.example.stockholmtoromev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UserMadeItToPageActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_made_it_to_page)
    }

    var flaglist = QuestionsList()
    var f: Destination = flaglist.listOfQuestions[0]




}