package dev.divyanshgemini.reciipiie.ui.auth

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseUser
import dev.divyanshgemini.reciipiie.data.repository.FirebaseAuthRepository

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val authRepository: FirebaseAuthRepository = FirebaseAuthRepository(application)
    private val pref: SharedPreferences = application.getSharedPreferences("reciipiie", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = pref.edit()

    private val _userLiveData = MutableLiveData<FirebaseUser?>()
    val userLiveData: LiveData<FirebaseUser?> = _userLiveData

    fun signInWithGoogle(intent: Intent) {
        val result = GoogleSignIn.getSignedInAccountFromIntent(intent)
        result.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val account = task.result
                if (account != null) {
                    val idToken = account.idToken
                    if (idToken != null) {

                        authRepository.firebaseAuthWithGoogle(idToken).observeForever { user ->
                            editor.putString("uid", user?.uid)
                            editor.putString("name", user?.displayName)
                            editor.putString("email", user?.email)
                            editor.putString("phone", user?.phoneNumber)
                            editor.putString("photoUrl", user?.photoUrl.toString())
                            editor.commit()

                            _userLiveData.postValue(user)
                        }
                    }
                }
            } else {
                _userLiveData.postValue(null)
            }
        }
    }

    fun getSignInIntent(): Intent {
        return authRepository.getGoogleSignInIntent()
    }
}