package com.michaelchanov.vodovoztestproject.presentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.michaelchanov.vodovoztestproject.R
import com.michaelchanov.vodovoztestproject.presentation.home.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment()).commit()
    }
}