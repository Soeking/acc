package com.example.user.dan

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_clear.*

class Clear : AppCompatActivity() {

    //private val score=intent.getIntExtra("SCORE",0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_clear)

        val score=intent.getIntExtra("SCORE",0)
        scoreBoard.text="$score"

        back.setOnClickListener{backTap(it)}
    }

    private fun backTap(view: View?){
        val intent = Intent(this,MainActivity::class.java)
        val score=intent.getIntExtra("SCORE",0)
        intent.putExtra("SCORE",score)
        startActivity(intent)
    }
}