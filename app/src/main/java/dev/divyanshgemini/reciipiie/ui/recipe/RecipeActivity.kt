package dev.divyanshgemini.reciipiie.ui.recipe

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import dev.divyanshgemini.reciipiie.R
import dev.divyanshgemini.reciipiie.databinding.ActivityRecipeBinding
import dev.divyanshgemini.reciipiie.ui.home.fragments.home.PopularRecipesAdapter
import dev.divyanshgemini.reciipiie.utils.Formatters

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeBinding
    private val viewModel: RecipeViewModel by viewModels()
    private val ingredientsAdapter = IngredientsAdapter()
    // private val equipmentsAdapter = EquipmentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeId = intent.getIntExtra("recipeId", -1)

        if (recipeId == -1) {
            finish()
        }

        // Observe recipe information & update UI
        viewModel.getRecipeInformation(recipeId).observe(this) { recipeInformation ->
            if (recipeInformation != null) {
                Glide.with(this)
                    .load(recipeInformation.image)
                    .into(binding.recipeImage)

                binding.recipeName.text = recipeInformation.title
                binding.readyInText.text = "${recipeInformation.readyInMinutes} min"
                binding.servingsText.text = recipeInformation.servings.toString()
                binding.pricePerServingText.text = recipeInformation.pricePerServing.toString()
                binding.instructions.text = recipeInformation.instructions
                binding.summary.text = Formatters.getHtml(recipeInformation.summary)

                // setup recyclerView for Popular Recipes
                with(binding.ingredientsRecyclerView) {
                    ingredientsAdapter.setIngredients(recipeInformation.extendedIngredients)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = this@RecipeActivity.ingredientsAdapter
                }

                // setup recyclerView for Popular Recipes
                /* with(binding.equipmentsRecyclerView) {
                    equipmentsAdapter.set(recipeInformation.extendedIngredients)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = this@RecipeActivity.equipmentsAdapter
                } */
            }
        }
    }
}