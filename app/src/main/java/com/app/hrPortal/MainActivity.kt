package com.app.hrPortal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        val navigateToLogin = Intent(this, LoginActivity::class.java)
//        startActivity(navigateToLogin)

        val navigateToSignup = Intent(this, SignupActivity::class.java)
        startActivity(navigateToSignup)
    }
}