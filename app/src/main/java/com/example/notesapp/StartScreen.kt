package com.example.notesapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        splashScreen.setKeepOnScreenCondition{true}
        setContentView(R.layout.activity_startscreen)
        addLoading(splashScreen)
    }
    private fun addLoading(splashScreen: androidx.core.splashscreen.SplashScreen){
        Handler(Looper.getMainLooper()).postDelayed({
            splashScreen.setKeepOnScreenCondition{false}
        },2000)
    }

}
