package com.hello.hellodoc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.hello.hellodoc.ui.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initiate()
    }

    private fun initiate() {
        findViewById<ImageView>(R.id.splash_logo).apply {
            val animation = AnimationUtils.loadAnimation(context, R.anim.spalsh_logo)
            startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                    this@SplashActivity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }

            })
        }
    }
}