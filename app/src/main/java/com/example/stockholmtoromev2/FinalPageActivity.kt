package com.example.stockholmtoromev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalPageActivity : AppCompatActivity() {

    lateinit var userSeeGameNameView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_page)

        userSeeGameNameView = findViewById(R.id.textView2)
    }
}