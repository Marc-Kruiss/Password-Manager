package com.example.dataexchange


import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val lottieAnimationView: LottieAnimationView =  findViewById(R.id.lootie)
        val backgroundimage:LottieAnimationView = findViewById(R.id.backgroundimg)
        // Animate Ending
        backgroundimage.animate().translationY(-3500f).setDuration(1000).startDelay = 5000
        lottieAnimationView.animate().translationY(3500f).setDuration(1000).setStartDelay(5000)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    val intent = Intent(this@SplashScreen, AuthActivity::class.java)
                    startActivity(intent)
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })

    }

}