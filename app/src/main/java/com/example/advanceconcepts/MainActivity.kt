package com.example.advanceconcepts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.advanceconcepts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.verTv.text = "ver 1"
    }
}