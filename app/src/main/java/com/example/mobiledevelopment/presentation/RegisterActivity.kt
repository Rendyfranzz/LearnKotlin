package com.example.mobiledevelopment.presentation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopment.data.model.User
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
        binding.signupButton.setActions {
            if (binding.etEmail.text.toString().isNotEmpty() && binding.etName.text.toString().isNotEmpty()
                && binding.etPassword.text.toString().isNotEmpty()) {
                AlertDialog.Builder(this).apply {
                    setTitle("Yeah!")
                    setMessage("Akunnya sudah jadi nih")
                    setPositiveButton("Lanjut") { _, _ ->
                        finish()
                    }
                    create()
                    show()
                }

            } else {
                Toast.makeText(this, "Oppsss ada kesalahan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun playAnimation() {


        val title = ObjectAnimator.ofFloat(binding.labelSignup, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val emailTextView = ObjectAnimator.ofFloat(binding.tilEmail, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.etEmail, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val passwordTextView = ObjectAnimator.ofFloat(binding.tilPassword, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val passwordEditTextLayout = ObjectAnimator.ofFloat(binding.etPassword, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val login = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(Constant.DURATION)

        AnimatorSet().apply {
            playSequentially(title, emailTextView, emailEditTextLayout, passwordTextView, passwordEditTextLayout, login)
            startDelay = Constant.DURATION
        }.start()
    }
    }