package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnGetpreferneces:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnGetpreferneces = findViewById(R.id.btnGetpreferneces)

        btnLogin.setOnClickListener {
            saveSharedPref()
        }

        btnGetpreferneces.setOnClickListener {
            getSharedPref()
        }

    }
    private fun saveSharedPref(){
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putString("username",username)
        editor.putString("password",password)

        editor.apply()
        Toast.makeText(
            this@LoginActivity,
            "username and password saved",
            Toast.LENGTH_LONG
        ).show()
    }
    private fun getSharedPref(){
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val password = sharedPref.getString("password", "")
        Toast.makeText(this, "Username:$username and password: $password",Toast.LENGTH_SHORT)
            .show()
    }
}


