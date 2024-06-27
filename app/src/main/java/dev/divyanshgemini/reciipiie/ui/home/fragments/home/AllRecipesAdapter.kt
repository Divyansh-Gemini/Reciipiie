package dev.divyanshgemini.reciipiie.ui.home.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.divyanshgemini.reciipiie.data.model.Recipe
import dev.divyanshgemini.reciipiie.databinding.LayoutPopularRecipeCardBinding
import dev.divyanshgemini.reciipiie.databinding.LayoutRecipeCardBinding

class AllRecipesAdapter : RecyclerView.Adapter<AllRecipesAdapter.AllRecipesViewHolder>() {

    private var recipes: List<Recipe> = listOf()

    fun setRecipes(recipes: List<Recipe>) {
        this.recipes = recipes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllRecipesViewHolder {
        val binding = LayoutRecipeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllRecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllRecipesViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    class AllRecipesViewHolder(private val binding: LayoutRecipeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            with(binding) {
                recipeName.text = recipe.title
                recipeDescription.text = "Ready in 25 min"
                Glide.with(recipeImage.context)
                    .load(recipe.image)
                    .into(recipeImage)
            }
        }
    }
}
