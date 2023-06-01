package com.example.mobiledevelopment.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopment.data.model.User
import com.example.mobiledevelopment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val user = User (
        "rendi",
        "rendi@gamil.com",
        "rendi"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        doLogin()
    }

    private fun doLogin() {
        binding.btnLogin.setActions {
            if (binding.etUsername.text.toString() == user.username &&
                binding.etPassword.text.toString() == user.password) {
                val intent = Intent(this, WelcomePageActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}