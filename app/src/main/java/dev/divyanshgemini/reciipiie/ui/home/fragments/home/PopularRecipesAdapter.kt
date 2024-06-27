package dev.divyanshgemini.reciipiie.ui.home.fragments.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.divyanshgemini.reciipiie.data.model.Recipe
import dev.divyanshgemini.reciipiie.databinding.LayoutPopularRecipeCardBinding
import dev.divyanshgemini.reciipiie.ui.recipe.RecipeActivity

class PopularRecipesAdapter : RecyclerView.Adapter<PopularRecipesAdapter.PopularRecipesViewHolder>() {

    private var recipes: List<Recipe> = listOf()

    fun setRecipes(recipes: List<Recipe>) {
        this.recipes = recipes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularRecipesViewHolder {
        val binding = LayoutPopularRecipeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularRecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularRecipesViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    class PopularRecipesViewHolder(private val binding: LayoutPopularRecipeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            with(binding) {
                recipeName.text = recipe.title
                recipeDescription.text = "Ready in 25 min"
                Glide.with(recipeImage.context)
                    .load(recipe.image)
                    .into(recipeImage)
            }

            binding.root.setOnClickListener {
                val intent = Intent(it.context, RecipeActivity::class.java)
                intent.putExtra("recipeId", recipe.id)
                it.context.startActivity(intent)
            }
        }
    }
}
