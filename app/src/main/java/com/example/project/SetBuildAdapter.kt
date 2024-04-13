package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SetBuildAdapter(private var ingredientList: ArrayList<Ingredient>) :
    RecyclerView.Adapter<SetBuildAdapter.IngredientViewHolder>() {

    // ViewHolder 클래스 정의
    class IngredientViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ingredientName: TextView = view.findViewById(R.id.ingredient_name)
        val ingredientQuantity: TextView = view.findViewById(R.id.ingredientQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.format_ingredientlist, parent, false)
        return IngredientViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient = ingredientList[position]
        holder.ingredientName.text = ingredient.name
        holder.ingredientQuantity.text = ingredient.quantity.toString()
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }
}


