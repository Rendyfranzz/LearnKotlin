package com.example.mobiledevelopment.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopment.R
import com.example.mobiledevelopment.databinding.ActivityWelcomePageBinding

class WelcomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getName()
    }
    private fun getName (){
        val name: String? = intent.getStringExtra("name")
        binding.nameTextView.text = getString(R.string.greeting,name)
    }
}