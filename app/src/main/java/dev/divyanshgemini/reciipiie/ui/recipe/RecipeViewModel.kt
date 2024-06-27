package dev.divyanshgemini.reciipiie.ui.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.divyanshgemini.reciipiie.data.model.RecipeInformationResponse
import dev.divyanshgemini.reciipiie.data.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    private val repository: RecipeRepository = RecipeRepository()
    private var recipeInformationLiveData: MutableLiveData<RecipeInformationResponse> = MutableLiveData()

    // Function to fetch recipe information from repository
    fun getRecipeInformation(recipeId: Int): LiveData<RecipeInformationResponse> {
        viewModelScope.launch {
            val result = repository.getRecipeInformation(recipeId).await()
            recipeInformationLiveData.value = result.value?.get(0)
        }

        return recipeInformationLiveData
    }
}