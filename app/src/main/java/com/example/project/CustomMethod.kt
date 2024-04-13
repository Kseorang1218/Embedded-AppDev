package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class CustomMethod : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choosecustommethod)

        val receivedList = intent.getSerializableExtra("IngredientList", ) as? ArrayList<Ingredient>

        val buildBtn = findViewById<Button>(R.id.buildBtn)
        buildBtn.setOnClickListener {
            val intent = Intent(this, SetBuildOrder::class.java)
            intent.putExtra("IngredientList", ArrayList<Ingredient>(receivedList))
            startActivity(intent)
        }

        val stiringBtn = findViewById<Button>(R.id.stiringBtn)
        stiringBtn.setOnClickListener {
            // TODO
        }
    }
}
