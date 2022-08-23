package com.example.googleads.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.googleads.databinding.ActivityMainBinding
import com.example.googleads.utils.BaseUtils.Companion.showMessage
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

class BannerADsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
        setADs()
    }

    private fun setUpUI() {
        adView = binding.adView
    }

    private fun setADs() {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        setADsListeners()
    }

    private fun setADsListeners() {
        adView.adListener = object : AdListener(){
            override fun onAdClicked() {
                super.onAdClicked()

            }
            override fun onAdClosed() {
                showMessage(findViewById(android.R.id.content),"Add closed")
            }
            override fun onAdFailedToLoad(adError : LoadAdError) {

            }
            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }
            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }
    }

    override fun onPause() {
        adView.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        adView.resume()
    }

    override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }


}