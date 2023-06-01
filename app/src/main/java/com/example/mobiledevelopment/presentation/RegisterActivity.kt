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
    val user = User (
        "rendi",
        "rendi@gamil.com",
        "rendi"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        doRegister()
    }
    private fun doRegister() {
        binding.signupButton.setActions {
            if (binding.etName.text.toString() == user.username &&
                binding.etPassword.text.toString() == user.password) {
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
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }