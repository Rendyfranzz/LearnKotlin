package com.example.mobiledevelopment.presentation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopment.data.model.User
import com.example.mobiledevelopment.databinding.ActivityMainBinding
import com.example.mobiledevelopment.utils.Constant

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val user = User (
        "rendi",
        "rendi@gamil.com",
        "rendi1234"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        doLogin()
        playAnimation()
    }

    private fun doLogin() {
        binding.btnLogin.setActions {
            // saya gatau kenapa gabisa pakek user.email
            if (binding.etEmail.text.toString() == "rendi@gmail.com"
                && binding.etPassword.text.toString()== "rendi1234") {
                AlertDialog.Builder(this).apply {
                    setTitle("Yeah!")
                    setMessage("Anda berhasil login ")
                    setPositiveButton("Lanjut") { _, _ ->
                        val intent = Intent(context, WelcomePageActivity::class.java).putExtra("name","Rendi")
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }
                    create()
                    show()
                }
            } else {
                Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun playAnimation() {

        val title = ObjectAnimator.ofFloat(binding.labelLogin, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val emailTextView = ObjectAnimator.ofFloat(binding.tilEmail, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.etEmail, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val passwordTextView = ObjectAnimator.ofFloat(binding.tilPassword, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val passwordEditTextLayout = ObjectAnimator.ofFloat(binding.etPassword, View.ALPHA, 1f).setDuration(Constant.DURATION)
        val login = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(
            Constant.DURATION)

        AnimatorSet().apply {
            playSequentially( title,emailTextView, emailEditTextLayout, passwordTextView, passwordEditTextLayout, login)
            startDelay = Constant.DURATION
        }.start()
    }
}