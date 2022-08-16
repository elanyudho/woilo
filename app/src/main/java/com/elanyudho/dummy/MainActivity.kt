package com.elanyudho.dummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elanyudho.dummy.databinding.ActivityLoginBinding
import com.elanyudho.dummy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}