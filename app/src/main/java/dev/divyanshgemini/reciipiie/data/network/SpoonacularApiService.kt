package dev.divyanshgemini.reciipiie.data.network

import dev.divyanshgemini.reciipiie.data.model.RecipeInformationResponse
import dev.divyanshgemini.reciipiie.data.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpoonacularApiService {
    @GET("recipes/complexSearch")
    suspend fun getRecipes(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("diet") diet: String = "Vegetarian",
        @Query("cuisine") cuisine: String = "Indian",
        @Query("sort") sort: String = "Popularity",
        @Query("excludeIngredients") excludeIngredients: String = "eggs"
    ): RecipeResponse

    @GET("recipes/{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String,
        @Query("includeNutrition") includeNutrition: Boolean,
        @Query("addWinePairing") addWinePairing: Boolean,
        @Query("addTasteData") addTasteData	: Boolean
    ): RecipeInformationResponse
}