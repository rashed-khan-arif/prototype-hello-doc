package com.hello.hellodoc

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import de.hdodenhof.circleimageview.CircleImageView

class CallingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling)
        val view = findViewById<CircleImageView>(R.id.avatar)
        val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

        view.startAnimation(animation)
    }
}