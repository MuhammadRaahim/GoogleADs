package com.example.googleads.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.googleads.R
import com.example.googleads.databinding.ActivityInterstitialAdsBinding
import com.example.googleads.utils.BaseUtils.Companion.showMessage
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialADsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInterstitialAdsBinding
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterstitialAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()
        setADs()
    }

    private fun setClickListeners() {
        binding.ivRefresh.setOnClickListener {
            setADs()
            binding.tvRefresh.isVisible = false
            binding.ivRefresh.isVisible = false
        }
    }

    private fun setADs() {
        var adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this,getString(R.string.interstitial_ads_id_Sample), adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
                showADs()
                binding.tvRefresh.isVisible = true
                binding.ivRefresh.isVisible = true
            }
        })
        setAdsListeners()
    }

    private fun showADs() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            showMessage(findViewById(android.R.id.content),getString(R.string.str_inatialization_failed))
        }
    }

    private fun setAdsListeners() {
        mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdClicked() {}
            override fun onAdDismissedFullScreenContent() {
                mInterstitialAd = null
            }
            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                mInterstitialAd = null
            }
            override fun onAdImpression() {}
            override fun onAdShowedFullScreenContent() {
            }
        }
    }
}