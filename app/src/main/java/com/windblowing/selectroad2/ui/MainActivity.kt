package com.windblowing.selectroad2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.windblowing.selectroad2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoSubActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity,SubActivity::class.java))

        }
    }
}
