package com.dynomo.ads_manager.ads.admob

import android.app.Activity
import android.view.ViewGroup
import com.dynomo.ads_manager.store.Store
import com.google.android.gms.ads.AdSize

internal class Util {
    companion object {
        fun calculateBannerSize (activity: Activity, view: ViewGroup): AdSize {
            val displayMetrics = activity.resources.displayMetrics
            val density = displayMetrics.density

            var adWidthPixels = view.width.toFloat()
            if (adWidthPixels == 0f) {
                adWidthPixels = displayMetrics.widthPixels.toFloat()
            }

            val adWidth = (adWidthPixels / density).toInt()
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth)
        }

        fun isEligibleToShowInterstitial ():Boolean {
            val timeNowUnix = System.currentTimeMillis()
            return timeNowUnix - Store.lastInterstitialShowTimeUnix >= Store.interstitialIntervalInSecond * 1000
        }
    }
}