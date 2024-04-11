package com.example.project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.InputStreamReader

class select : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_select)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cocktailName = intent.getStringExtra("COCKTAIL_NAME") ?: return

        val cocktailImg = findViewById<ImageView>(R.id.cocktail_img)
        val imageId = resources.getIdentifier(cocktailName, "drawable", packageName)

        val content= readTextFile(this,cocktailName)
        cocktailImg.setImageResource(imageId)
        val cocktailTextView = findViewById<TextView>(R.id.textView)
        cocktailTextView.text = content
        val cocktailNameView = findViewById<TextView>(R.id.cocktail_name)
        cocktailNameView.text = cocktailName
        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            finish()
        }
    }
}

fun readTextFile(context: Context, fileName: String): String {
    val resourceId = context.resources.getIdentifier(fileName, "raw", context.packageName)
    if (resourceId == 0) {
        throw IllegalArgumentException("The given file name does not correspond to a resource in raw folder.")
    }

    context.resources.openRawResource(resourceId).use { inputStream ->
        val reader = BufferedReader(InputStreamReader(inputStream))
        val content = StringBuilder()
        var line: String? = reader.readLine()
        while (line != null) {
            content.append(line)
            line = reader.readLine()
        }
        return content.toString()
    }
}