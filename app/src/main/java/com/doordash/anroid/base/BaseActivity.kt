package com.doordash.anroid.base

import android.os.Bundle
import android.view.WindowManager


import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

/**
 * BaseActivity
 */

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) // mock dont have status bar
    }
}
