package com.example.googleads.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.googleads.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()

    }

    private fun setClickListeners() {
        binding.apply {
            btnBanner.setOnClickListener {
               startActivity(Intent(this@HomeActivity,BannerADsActivity::class.java))
            }
            btnInterstitial.setOnClickListener {
                startActivity(Intent(this@HomeActivity,InterstitialADsActivity::class.java))
            }
        }
    }
}