package com.example.project

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader

class choose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose)

        val recyclerView: RecyclerView = findViewById(R.id.cocktail_list)
        val cock_name = listOf(
            "matini",
            "ginfizz",
            "gintonic",
            "orangeblossom",
            "paradise",
            "tomcollins",
            "whitelady"
        )
        val adapter = CocktaillistAdapter(cock_name)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn7 = findViewById<Button>(R.id.btn_back)
        btn7.setOnClickListener {
            finish()
        }



//        val btn = findViewById<Button>(R.id.button)
//        btn.setOnClickListener {
//            val fileContent = readTextFile(this, R.raw.a)
//            val intent = Intent(this, select::class.java).apply {
//                putExtra("fileContent", fileContent)
//            }
//            startActivity(intent)
//        }
    }
}

fun readTextFile(context: Context, resourceId: Int): String {
    val inputStream = context.resources.openRawResource(resourceId)
    val reader = BufferedReader(inputStream.reader())
    val content = reader.use { it.readText() }
    return content
}