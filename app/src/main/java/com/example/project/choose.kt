package com.example.project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class choose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn7 = findViewById<Button>(R.id.button7)
        btn7.setOnClickListener {
            finish()
        }
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val fileContent = readTextFile(this, R.raw.a)
            val intent = Intent(this, select::class.java).apply {
                putExtra("fileContent", fileContent)
            }
            startActivity(intent)
        }
    }
}

fun readTextFile(context: Context, resourceId: Int): String {
    val inputStream = context.resources.openRawResource(resourceId)
    val reader = BufferedReader(inputStream.reader())
    val content = reader.use { it.readText() }
    return content
}