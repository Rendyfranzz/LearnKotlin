package com.example.mobiledevelopment.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopment.databinding.GuestViewBinding

class GuestActivity : AppCompatActivity() {
    private lateinit var binding: GuestViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GuestViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigate()
    }
    private fun navigate() {
        binding.loginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.signupButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}