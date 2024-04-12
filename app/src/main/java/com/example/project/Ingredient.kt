package com.example.project
import java.io.Serializable

data class Ingredient(var name: String, var quantity: Int = 0) : Serializable {
    fun getNameAndQuantity(): Pair<String, Int> {
        return Pair(name, quantity)
    }
}