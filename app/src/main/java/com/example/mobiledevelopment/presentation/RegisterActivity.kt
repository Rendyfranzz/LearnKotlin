package com.example.mobiledevelopment.presentation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopment.databinding.ActivityRegisterBinding
import com.example.mobiledevelopment.utils.Constant

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        doRegister()
        playAnimation()
    }
    private fun doRegister() {
        binding.signupButton.setOnClickListener {

                val intent = Intent(this, WelcomePageActivity::class.java)
                startActivity(intent)

        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -30f, 30f).apply {
            duration = Constant.IMAGE_DURATION
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val nameTextView = ObjectAnimator.ofFloat(binding.nameEditText, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val nameEditTextLayout = ObjectAnimator.ofFloat(binding.nameEditTextLayout, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val emailTextView = ObjectAnimator.ofFloat(binding.emailEditText, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val passwordTextView = ObjectAnimator.ofFloat(binding.passwordEditText, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val passwordEditTextLayout = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(500)


        AnimatorSet().apply {
            playSequentially(
                title,
                nameTextView,
                nameEditTextLayout,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                signup
            )
            startDelay = Constant.DURATION
        }.start()
    }
}