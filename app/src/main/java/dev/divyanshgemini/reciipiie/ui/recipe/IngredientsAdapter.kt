package dev.divyanshgemini.reciipiie.ui.recipe

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.divyanshgemini.reciipiie.data.model.ExtendedIngredient
import dev.divyanshgemini.reciipiie.databinding.LayoutCircularCardBinding

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {

    private var ingredients: List<ExtendedIngredient> = listOf()

    fun setIngredients(ingredients: List<ExtendedIngredient>) {
        this.ingredients = ingredients
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val binding = LayoutCircularCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int = ingredients.size

    class IngredientsViewHolder(private val binding: LayoutCircularCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: ExtendedIngredient) {
            with(binding) {
                textView.text = ingredient.nameClean
                Glide.with(imageView.context)
                    .load("https://img.spoonacular.com/ingredients_250x250/${ingredient.image}")
                    .into(imageView)
            }
        }
    }
}
