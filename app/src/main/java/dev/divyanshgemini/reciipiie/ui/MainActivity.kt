package dev.divyanshgemini.reciipiie.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.divyanshgemini.reciipiie.databinding.ActivityMainBinding
import dev.divyanshgemini.reciipiie.ui.auth.AuthActivity
import dev.divyanshgemini.reciipiie.ui.home.HomeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences("reciipiie", Context.MODE_PRIVATE)

        if (pref.getString("uid", "")?.isNotBlank()!!) {
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            startActivity(Intent(this, AuthActivity::class.java))
        }
        finish()
    }
}