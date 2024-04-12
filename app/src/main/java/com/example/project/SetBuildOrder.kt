package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class SetBuildOrder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_setbuildorder)
        val receivedList = intent.getSerializableExtra("IngredientList", ) as? ArrayList<Ingredient>

        println(receivedList)

        val recyclerView: RecyclerView = findViewById(R.id.cocktail_ingredients_list)
//        val adapter = CocktaillistAdapter(cocktail_names, object : OnCocktailClickListener {
//            override fun onCocktailClick(name: String) {
//                val intent = Intent(this@choose, select::class.java)
//                intent.putExtra("COCKTAIL_NAME", name)
//                startActivity(intent)
//            }
//        })

        // 시스템 바 인셋 적용
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            finish()
        }
    }
}