package dev.divyanshgemini.reciipiie.ui.home.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.divyanshgemini.reciipiie.data.model.Recipe
import dev.divyanshgemini.reciipiie.data.repository.RecipeRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository: RecipeRepository = RecipeRepository()

    private val _popularRecipes = MutableLiveData<List<Recipe>>()
    val popularRecipes: LiveData<List<Recipe>> get() = _popularRecipes

    private val _allRecipes = MutableLiveData<List<Recipe>>()
    val allRecipes: LiveData<List<Recipe>> get() = _allRecipes

    init {
        loadPopularRecipes()
        loadAllRecipes()
    }

    private fun loadPopularRecipes() {
        viewModelScope.launch {
            val result = repository.getPopularRecipes("").await()
            _popularRecipes.value = result.value
        }
    }

    private fun loadAllRecipes() {
        viewModelScope.launch {
//            val result = repository.getPopularRecipes("").await()
//            _popularRecipes.value = result.value
        }
    }
}