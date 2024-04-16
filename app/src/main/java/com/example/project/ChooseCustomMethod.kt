package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.net.Socket


// [Ingredient(name=ex1, quantity=1), Ingredient(name=ex2, quantity=1), Ingredient(name=ex3, quantity=1), Ingredient(name=ex4, quantity=0), Ingredient(name=ex5, quantity=0), Ingredient(name=ex6, quantity=0), Ingredient(name=ex7, quantity=0)]
class ChooseCustomMethod : AppCompatActivity() {

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

        val formattedData = formatDataForCommunication(receivedList)
        println(formattedData)

        val stiringBtn = findViewById<Button>(R.id.stiringBtn)
        stiringBtn.setOnClickListener {
//            Thread{
//                try{
//                    val socket = Socket("10.0.0.2", 3000)
//                    socket.use { s->
//                        val outStream = s.outputStream
//                        val inStream = s.inputStream
//
//                        val data = "2\n\n"
//                    }
//                }
//            }
        }
    }
}

fun formatDataForCommunication(ingredients: ArrayList<Ingredient>?): String {
    val header = "2"
    val body = StringBuilder()

    // Assuming ingredients are always in the fixed order from ex1 to ex7
    // Append the quantity of each ingredient followed by a newline. If the ingredient is null or the list is incomplete, append 0.
    val expectedIngredients = listOf("ex1", "ex2", "ex3", "ex4", "ex5", "ex6", "ex7")
    expectedIngredients.forEach { ingredientName ->
        val quantity = ingredients?.find { it.name == ingredientName }?.quantity ?: 0
        body.append("$quantity\n")
    }

    // Format the complete data string
    return "$header\n\n${body.toString()}"
}