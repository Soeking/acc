package com.example.user.dan

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_gameover.*

class Gameover : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_gameover)

        scoreBoard.text="$score"

        retryButton.setOnClickListener{retryTap()}
    }

    private fun retryTap(){
        val intent = Intent(this,Start::class.java)
        startActivity(intent)
    }
}
