package dev.divyanshgemini.reciipiie.ui.home.fragments.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.divyanshgemini.reciipiie.R
import dev.divyanshgemini.reciipiie.databinding.FragmentHomeBinding
import dev.divyanshgemini.reciipiie.utils.Formatters

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val popularRecipesAdapter = PopularRecipesAdapter()
    private val allRecipesAdapter = AllRecipesAdapter()
    private lateinit var pref: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = requireActivity().getSharedPreferences("reciipiie", Context.MODE_PRIVATE)

        // set user's first name in welcome text
        val userName = pref.getString("name", "User")!!
        val firstName = Formatters.getFirstName(userName)
        binding.welcomeText.text = getString(R.string.hey_user, firstName)

        // setup recyclerView for Popular Recipes
        with(binding.popularRecipesRecyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.popularRecipesAdapter
        }

        // observe popular recipes
        viewModel.popularRecipes.observe(viewLifecycleOwner) { recipes ->
            popularRecipesAdapter.setRecipes(recipes)
        }

        // setup recyclerView for All Recipes
        with(binding.allRecipesRecyclerView) {
            layoutManager = object : LinearLayoutManager(requireContext()) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            adapter = this@HomeFragment.allRecipesAdapter
        }

        // observe all recipes
        viewModel.popularRecipes.observe(viewLifecycleOwner) { recipes ->
            allRecipesAdapter.setRecipes(recipes.reversed())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}