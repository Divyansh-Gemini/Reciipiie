package dev.divyanshgemini.reciipiie.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dev.divyanshgemini.reciipiie.databinding.ActivityAuthenticationBinding
import dev.divyanshgemini.reciipiie.ui.home.HomeActivity

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val signInIntent = viewModel.getSignInIntent()
            startActivityForResult(signInIntent, 9001)
        }

        viewModel.userLiveData.observe(this) { user ->
            if (user != null) {
                Toast.makeText(this@AuthActivity, "Signed in successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@AuthActivity, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this@AuthActivity, "Failed to sign in", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 9001) {
            Log.i("AuthActivity", "reqCode == 9001")
            viewModel.signInWithGoogle(data!!)
        }
    }
}