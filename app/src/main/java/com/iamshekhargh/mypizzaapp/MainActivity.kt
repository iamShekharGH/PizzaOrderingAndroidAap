package com.iamshekhargh.mypizzaapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            hideStatusBar()
        } else {
            hideStatusBarDeprecated()
        }
        supportActionBar?.hide()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun hideStatusBar() {
        window.decorView.windowInsetsController?.hide(
            android.view.WindowInsets.Type.statusBars()
        )
    }

    private fun hideStatusBarDeprecated() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}