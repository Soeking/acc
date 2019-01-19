package com.example.user.dan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.view.View
import kotlinx.android.synthetic.main.activity_start.*

class Start : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_start)

        score=0

         startButton.setOnClickListener{startTap()}
    }

    private fun startTap(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}