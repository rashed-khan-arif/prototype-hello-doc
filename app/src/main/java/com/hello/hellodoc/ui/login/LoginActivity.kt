package com.hello.hellodoc.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hello.hellodoc.DoctorActivity
import com.hello.hellodoc.MainActivity
import com.hello.hellodoc.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.apply {
            setOnClickListener {
                startActivity(Intent(context, MainActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            }
        }
    }
}
