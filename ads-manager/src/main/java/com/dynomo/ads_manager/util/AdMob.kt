package com.dynomo.ads_manager.util

import android.app.Activity
import android.view.ViewGroup
import com.google.android.gms.ads.AdSize

class AdMob {
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
    }
}