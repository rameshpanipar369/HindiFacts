package com.example.amazingfacts.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.amazingfacts.R
import com.example.amazingfacts.fragment.CategoryFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, CategoryFragment()).addToBackStack(null).commit()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if (count == 0) {
            super.onBackPressed()
            //additional code
        } else {
            supportFragmentManager.popBackStack()
        }

    }
}