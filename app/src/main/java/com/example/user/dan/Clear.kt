package com.example.user.dan

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_clear.*

class Clear : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_clear)

        score++
        scoreBoard.text="$score"

        back.setOnClickListener{backTap()}
    }

    private fun backTap(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}