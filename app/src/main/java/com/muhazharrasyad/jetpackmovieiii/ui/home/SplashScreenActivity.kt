package com.muhazharrasyad.jetpackmovieiii.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.muhazharrasyad.jetpackmovieiii.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ivSplashScreen: ImageView = findViewById(R.id.iv_splash_screen)
        ivSplashScreen.alpha = 0f
        ivSplashScreen.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}