package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn1 = findViewById<Button>(R.id.button1)
        btn1.setOnClickListener {
            val intent = Intent(this, choose::class.java)
            startActivity(intent)
        }
        val btn2 = findViewById<Button>(R.id.button2)
        btn2.setOnClickListener {
            val intent = Intent(this, chat::class.java)
            startActivity(intent)
        }
        val btn3 = findViewById<Button>(R.id.custom)
        btn3.setOnClickListener {
            val intent = Intent(this, Custom::class.java)
            startActivity(intent)
        }
    }
}