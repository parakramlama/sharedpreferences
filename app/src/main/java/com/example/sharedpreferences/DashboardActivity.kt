package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {

    private lateinit var btnRun: Button
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnRun = findViewById(R.id.btnRun)
        btnShare = findViewById(R.id.btnShare)


        btnShare.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnRun.setOnClickListener {
            startActivity(Intent(this, PermissionActivity::class.java))
        }


    }
}
